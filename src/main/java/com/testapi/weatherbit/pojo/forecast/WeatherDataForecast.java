package com.testapi.weatherbit.pojo.forecast;

import java.util.Date;

import com.testapi.weatherbit.pojo.WeatherDescription;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataForecast {

    private int dni;
    private int pop;
    private int ozone;
    private int clouds_hi;
    private int clouds_low;
    private int clouds_mid;
    private Date timestamp_utc;
    private Date timestamp_local;
    private String wind_cdir;
    private int rh;
    private String pod;
    private int pres;
    private int clouds;
    private double vis;
    private double wind_spd;
    private String wind_cdir_full;
    private int slp;
    private String datetime;
    private int ts;
    private int snow;
    private double wind_gust_spd;
    private double dewpt;
    private int uv;
    private int wind_dir;
    private int ghi;
    private int dhi;
    private int precip;
    private WeatherDescription weather;
    private double temp;
    private double app_temp;
    private int solar_rad;
    private int snow_depth;
    private double app_max_temp;
    private double app_min_temp;
    private double high_temp;
    private double low_temp;
    private Object max_dhi;
    private double max_temp;
    private double min_temp;
    private double moon_phase;
    private double moon_phase_lunation;
    private int moonrise_ts;
    private int moonset_ts;
    private int sunrise_ts;
    private int sunset_ts;
    private String valid_date;
}