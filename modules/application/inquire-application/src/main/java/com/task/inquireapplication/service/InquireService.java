package com.task.inquireapplication.service;

import com.task.inquireapplication.dto.response.GetForecastListResponseDto;
import org.springframework.http.ResponseEntity;

public interface InquireService {
    ResponseEntity<? super GetForecastListResponseDto> getForecastList();
}