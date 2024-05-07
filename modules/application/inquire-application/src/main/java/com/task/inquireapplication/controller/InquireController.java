package com.task.inquireapplication.controller;


import com.task.inquireapplication.dto.response.GetForecastListResponseDto;
import com.task.inquireapplication.service.InquireService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task/inquire")
@AllArgsConstructor
public class InquireController {

    private final InquireService inquireService;

    @GetMapping("")
    public ResponseEntity<? super GetForecastListResponseDto> postForecast(
    ){
        return inquireService.getForecastList();
    }
}