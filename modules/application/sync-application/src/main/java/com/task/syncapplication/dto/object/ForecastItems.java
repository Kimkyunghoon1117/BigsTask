package com.task.syncapplication.dto.object;

import lombok.Data;

import java.util.List;

@Data
public class ForecastItems {

    private List<ForecastItem> item;
    private int pageNo;
    private int numOfRows;
    private int totalCount;
}
