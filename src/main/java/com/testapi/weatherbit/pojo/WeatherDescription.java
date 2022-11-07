package com.testapi.weatherbit.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import  lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDescription {

    private String description;
    private int code;
    private String icon;
}