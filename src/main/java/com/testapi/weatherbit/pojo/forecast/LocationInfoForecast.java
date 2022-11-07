package com.testapi.weatherbit.pojo.forecast;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import  lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationInfoForecast {

    private List<WeatherDataForecast> data;
    private double lon;
    private String country_code;
    private double lat;
    private String timezone;
    private String city_name;
    private String state_code;
}