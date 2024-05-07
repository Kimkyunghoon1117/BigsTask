package com.task.syncapplication.dto.object;

import lombok.Data;

@Data
public class ForecastItem {

    private String baseDate;
    private String baseTime;
    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private int nx;
    private int ny;
}
