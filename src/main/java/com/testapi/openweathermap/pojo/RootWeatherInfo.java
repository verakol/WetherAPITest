package com.testapi.openweathermap.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import  lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RootWeatherInfo {

    private Coordinates coord;
    private ArrayList<WeatherDescriptionInfo> weather;
    private String base;
    private MainWeatherInfo main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private SysInfo sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
    private Rain rain;
}