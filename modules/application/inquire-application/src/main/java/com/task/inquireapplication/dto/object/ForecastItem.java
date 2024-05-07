package com.task.inquireapplication.dto.object;

import com.task.forecastdomain.entity.ForecastEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public ForecastItem(ForecastEntity entity) {
        this.baseDate = entity.getBaseDate();
        this.baseTime = entity.getBaseTime();
        this.category = entity.getCategory();
        this.fcstDate = entity.getFcstDate();
        this.fcstTime = entity.getFcstTime();
        this.fcstValue = entity.getFcstValue();
        this.nx = entity.getNx();
        this.ny = entity.getNy();
    }

    public static List<ForecastItem> copyList(List<ForecastEntity> entities) {
        List<ForecastItem> list  = new ArrayList<>();
        for(ForecastEntity entity : entities){
            ForecastItem forecastItem = new ForecastItem(entity);
            list.add(forecastItem);
        }
        return list;
    }
}
