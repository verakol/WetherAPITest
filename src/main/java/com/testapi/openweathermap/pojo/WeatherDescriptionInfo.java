package com.testapi.openweathermap.pojo;

import lombok.Data;
import lombok.Builder;
import  lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDescriptionInfo {

    private int id;
    private String main;
    private String description;
    private String icon;
}