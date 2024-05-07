package com.task.syncapplication.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostForecastRequestDto {

    private String url;
    private String serviceKey;
    private int numOfRows;
    private int pageNo;
    private String dataType;
    private String base_date;
    private String base_time;
    private int nx;
    private int ny;
}
