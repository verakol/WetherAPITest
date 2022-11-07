package com.testapi.weatherbit.controller;

import com.testapi.weatherbit.pojo.forecast.LocationInfoForecast;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static com.testapi.Utils.getProperty;
import static io.restassured.RestAssured.given;


public class ForecastController {

    private String baseRapidAPIUri = getProperty("baseRapidAPIUri");
    private String headerParameterKey = getProperty("headerParameterKey");
    private String headerParameterKeyValue = getProperty("keyValue");
    private String headerParameterHost = getProperty("headerParameterHost");
    private String headerParameterHostValue = getProperty("hostValue");
    private String forecastPath = getProperty("forecastPath");
    private String hourlyIntervalParam = getProperty("hourlyIntervalParam");
    private String threeHourlyIntervalParam = getProperty("threeHourlyIntervalParam");
    private String minutelyIntervalParam = getProperty("minutelyIntervalParam");
    private String dailyIntervalParam = getProperty("dailyIntervalParam");
    private String lat = getProperty("lat");
    private String lon = getProperty("lon");
    private String city = getProperty("city");
    private String country = getProperty("country");

    public RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseRapidAPIUri)
            .addHeader(headerParameterKey, headerParameterKeyValue)
            .addHeader(headerParameterHost, headerParameterHostValue)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build();

    public List<LocationInfoForecast> getFiveDayForecastThreeHourlyInterval(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .basePath(forecastPath)
                .pathParam("interval", threeHourlyIntervalParam)
                .queryParam("lat", lat)
                .and()
                .queryParam("lon", lon)
                .when().get("{interval}")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and()
                .extract().response().as(LocationInfoForecast.class));
    }

    public List<LocationInfoForecast> getOneHourForecastMinutelyInterval(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .basePath(forecastPath)
                .pathParam("interval", minutelyIntervalParam)
                .queryParam("lat", lat)
                .and()
                .queryParam("lon", lon)
                .when().get("{interval}")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and()
                .extract().response().as(LocationInfoForecast.class));
    }

    public List<LocationInfoForecast> getForecastDailyInterval(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .basePath(forecastPath)
                .pathParam("interval", dailyIntervalParam)
                .queryParam("city", city)
                .and()
                .queryParam("country", country)
                .when().get("{interval}")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and()
                .extract().response().as(LocationInfoForecast.class));
    }

    public List<LocationInfoForecast> getForecastHourlyInterval(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .basePath(forecastPath)
                .pathParam("interval", hourlyIntervalParam)
                .queryParam("lat", lat)
                .and()
                .queryParam("lon", lon)
                .and()
                .queryParam("hours", "48")
                .when().get("{interval}")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and()
                .extract().response().as(LocationInfoForecast.class));
    }
}