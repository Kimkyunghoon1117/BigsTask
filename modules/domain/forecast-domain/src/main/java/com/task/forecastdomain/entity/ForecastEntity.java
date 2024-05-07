package com.task.forecastdomain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="forecast_entity")
public class ForecastEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int forecastNumber;
    private String baseDate;
    private String baseTime;
    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private int nx;
    private int ny;

    public ForecastEntity(String baseDate, String baseTime, String category, String fcstDate,
                          String fcstTime, String fcstValue, int nx, int ny){
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.category = category;
        this.fcstDate = fcstDate;
        this.fcstTime = fcstTime;
        this.fcstValue = fcstValue;
        this.nx = nx;
        this.ny = ny;
    }

}

