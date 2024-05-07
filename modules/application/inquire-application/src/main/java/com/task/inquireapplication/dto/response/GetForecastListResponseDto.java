package com.task.inquireapplication.dto.response;

import com.task.forecastdomain.entity.ForecastEntity;
import com.task.inquireapplication.dto.object.ForecastItem;
import com.task.inquireapplication.dto.response.common.ResponseCode;
import com.task.inquireapplication.dto.response.common.ResponseDto;
import com.task.inquireapplication.dto.response.common.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetForecastListResponseDto extends ResponseDto {

    private List<ForecastItem> forecastList;
    private GetForecastListResponseDto(List<ForecastEntity> entities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.forecastList = ForecastItem.copyList(entities);
    }

    public static ResponseEntity<GetForecastListResponseDto> success(List<ForecastEntity> entities){
        GetForecastListResponseDto result = new GetForecastListResponseDto(entities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noContent(){
        ResponseDto result = new ResponseDto(ResponseCode.NO_CONTENT,ResponseMessage.NO_CONTENT);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }
}
