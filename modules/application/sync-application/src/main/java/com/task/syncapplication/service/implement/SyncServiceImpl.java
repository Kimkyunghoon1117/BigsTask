package com.task.syncapplication.service.implement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.task.forecastdomain.entity.ForecastEntity;
import com.task.forecastdomain.repository.ForecastRepository;
import com.task.syncapplication.dto.object.ForecastApiResponse;
import com.task.syncapplication.dto.object.ForecastItem;
import com.task.syncapplication.dto.request.PostForecastRequestDto;
import com.task.syncapplication.dto.response.PostForecastResponseDto;
import com.task.syncapplication.dto.response.common.ResponseDto;
import com.task.syncapplication.service.SyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SyncServiceImpl implements SyncService {

    private final ForecastRepository forecastRepository;

    @Override
    public ResponseEntity<? super PostForecastResponseDto> postForecast(PostForecastRequestDto dto) {

        System.out.println("ForecastRepository :"+forecastRepository);
        try {
            // 1. 기존 데이터 삭제
            if(forecastRepository.count() > 0)
                forecastRepository.deleteAll();
            // 2. 외부 api 호출
            List<ForecastItem> list = callForecastApi(dto);
        
            // 3. db 저장
            for(ForecastItem item : list){
                ForecastEntity forecastEntity = new ForecastEntity(
                        item.getBaseDate(), item.getBaseTime(), item.getCategory(),
                        item.getFcstDate(), item.getFcstTime(), item.getFcstValue(),
                        item.getNx(), item.getNy()
                );
                forecastRepository.save(forecastEntity);
            }

        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostForecastResponseDto.success();
    }

    @Override
    public List<ForecastItem> callForecastApi(PostForecastRequestDto dto) throws UnsupportedEncodingException, URISyntaxException, JsonProcessingException {
        // dto 임시 설정
        Date now = Date.from(Instant.now().minus(1, ChronoUnit.DAYS));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        dto.setUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst");
        dto.setServiceKey("PQexRtUKq8nvl0EwuruPgtIuaJVrlP2VDldqBwqF1bgZemxHYaSUj5USsQ9S040rGLig7wDkXG2eXofij1%2Bvag%3D%3D");
        dto.setPageNo(1);
        dto.setNumOfRows(1000);
        dto.setDataType("JSON");
        dto.setBase_date(simpleDateFormat.format(now));
        dto.setBase_time("0500");
        dto.setNx(61);
        dto.setNy(130);

        // RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        // Header 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // URI 설정
        StringBuilder builder = new StringBuilder(dto.getUrl());
        builder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + dto.getServiceKey());
        builder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(dto.getPageNo()), "UTF-8"));
        builder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(dto.getNumOfRows()), "UTF-8"));
        builder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode(dto.getDataType(), "UTF-8"));
        builder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(dto.getBase_date(), "UTF-8"));
        builder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode(dto.getBase_time(), "UTF-8"));
        builder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(dto.getNx()), "UTF-8"));
        builder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(dto.getNy()), "UTF-8"));
        URI uri = new URI(builder.toString());

        // Entity 생성
        HttpEntity entity = new HttpEntity(headers);

        // API 호출
        ResponseEntity<ForecastApiResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, ForecastApiResponse.class);


        if(response.getBody().getResponse().getBody()==null) return new ArrayList<ForecastItem>();

        return response.getBody().getResponse().getBody().getItems().getItem();
    }
}
