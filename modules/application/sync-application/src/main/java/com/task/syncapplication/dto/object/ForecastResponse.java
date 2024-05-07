package com.task.syncapplication.dto.object;

import lombok.Data;

@Data
public class ForecastResponse {

    private ForecastHeader header;
    private ForecastBody body;
}
