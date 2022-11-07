package com.weatherbit.tests;

import com.testapi.weatherbit.controller.CurrentWeatherController;
import com.testapi.weatherbit.pojo.current.CurrentWeatherDataPojo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.testapi.weatherbit.Utils.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CurrentWeatherTests extends CurrentWeatherController {

    private CurrentWeatherController currentWeather;
    private double expectedLat = Double.parseDouble(getProperty("lat"));
    private double expectedLon = Double.parseDouble(getProperty("lon"));

    @BeforeMethod
    public void setUp(){currentWeather = new CurrentWeatherController();}

   @Test
    public void getCurrentDayWeather(){
        List<CurrentWeatherDataPojo> currentWeatherData = currentWeather.getCurrentWeather();
        assertThat(currentWeatherData.size(), greaterThan(0));

        double actualLat = currentWeatherData.get(0).getLat();
        double actualLon = currentWeatherData.get(0).getLon();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLat,expectedLat);
        softAssert.assertEquals(actualLon,expectedLon);
        softAssert.assertAll();
    }
}