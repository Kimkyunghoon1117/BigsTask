package com.task.syncapplication.dto.object;

import lombok.Data;

@Data
public class ForecastBody {

    private String dataType;
    private ForecastItems items;
}
