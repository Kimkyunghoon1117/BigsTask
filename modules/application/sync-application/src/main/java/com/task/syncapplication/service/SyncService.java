package com.task.syncapplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.task.syncapplication.dto.request.PostForecastRequestDto;
import com.task.syncapplication.dto.response.PostForecastResponseDto;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

public interface SyncService {
    ResponseEntity<? super PostForecastResponseDto> postForecast(PostForecastRequestDto dto);

    List callForecastApi(PostForecastRequestDto dto) throws UnsupportedEncodingException, URISyntaxException, JsonProcessingException;
}