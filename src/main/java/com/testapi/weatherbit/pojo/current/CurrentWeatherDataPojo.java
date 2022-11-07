package com.testapi.weatherbit.pojo.current;

import com.testapi.weatherbit.pojo.WeatherDescription;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeatherDataPojo {

    private double app_temp;
    private int aqi;
    private String city_name;
    private int clouds;
    private String country_code;
    private String datetime;
    private double dewpt;
    private double dhi;
    private double dni;
    private double elev_angle;
    private double ghi;
    private double gust;
    private int h_angle;
    private double lat;
    private double lon;
    private String ob_time;
    private String pod;
    private int precip;
    private double pres;
    private int rh;
    private int slp;
    private int snow;
    private double solar_rad;
    private ArrayList<String> sources;
    private String state_code;
    private String station;
    private String sunrise;
    private String sunset;
    private double temp;
    private String timezone;
    private int ts;
    private double uv;
    private int vis;
    private WeatherDescription weather;
    private String wind_cdir;
    private String wind_cdir_full;
    private int wind_dir;
    private double wind_spd;
}