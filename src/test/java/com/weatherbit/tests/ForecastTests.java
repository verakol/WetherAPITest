package com.weatherbit.tests;

import com.testapi.weatherbit.controller.ForecastController;
import com.testapi.weatherbit.pojo.forecast.LocationInfoForecast;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ForecastTests{

    private ForecastController forecast;

    @BeforeMethod
    public void setUpTest() {forecast = new ForecastController(); }

    @Test
    public void getForecastForFiveDays(){
        List<LocationInfoForecast> forecastWeather = forecast.getFiveDayForecastThreeHourlyInterval();
        assertThat("Get weather forecast for 5 days is empty", forecastWeather.size(), greaterThan(0));
    }

    @Test
    public void getForecastForOneHour(){
        List<LocationInfoForecast> forecastWeather = forecast.getOneHourForecastMinutelyInterval();
        int forecastDataSize = forecastWeather.stream().map(LocationInfoForecast::getData).collect(Collectors.toList()).get(0).size();
        assertThat("Get Minutely weather forecast for 1 hour is empty", forecastDataSize,equalTo(60));
    }

    @Test
    public void getDailyForecast(){
        List<LocationInfoForecast> dailyForecast = forecast.getForecastDailyInterval();
        int dailyForecastDataSize = dailyForecast.stream().map(LocationInfoForecast::getData).collect(Collectors.toList()).get(0).size();
        assertThat("Get Minutely weather forecast for 1 hour is empty", dailyForecastDataSize,equalTo(16));
    }

    @Test
    public void getForecastWithHourlyInterval(){
        List<LocationInfoForecast> hourlyForecast = forecast.getForecastHourlyInterval();
        int hourlyForecastDataSize = hourlyForecast.stream().map(LocationInfoForecast::getData).collect(Collectors.toList()).get(0).size();
        assertThat("Get Minutely weather forecast for 1 hour is empty", hourlyForecastDataSize,equalTo(48));
    }
}