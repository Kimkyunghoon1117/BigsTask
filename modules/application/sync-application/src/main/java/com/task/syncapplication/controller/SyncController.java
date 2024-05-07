package com.task.syncapplication.controller;

import com.task.syncapplication.dto.request.PostForecastRequestDto;
import com.task.syncapplication.dto.response.PostForecastResponseDto;
import com.task.syncapplication.service.SyncService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task/sync")
@AllArgsConstructor
public class SyncController {

    private final SyncService syncService;

    @PostMapping("")
    public ResponseEntity<? super PostForecastResponseDto> postForecast(
        @RequestBody PostForecastRequestDto requestBody
    ){
        return syncService.postForecast(requestBody);
    }
}