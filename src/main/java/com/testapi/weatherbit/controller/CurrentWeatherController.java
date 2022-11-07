package com.testapi.weatherbit.controller;

import com.testapi.weatherbit.pojo.current.CurrentWeatherDataPojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.List;

import static com.testapi.Utils.getProperty;
import static io.restassured.RestAssured.given;

public class CurrentWeatherController {

    private String baseRapidAPIUri = getProperty("baseRapidAPIUri");
    private String headerParameterKey = getProperty("headerParameterKey");
    private String headerParameterKeyValue = getProperty("keyValue");
    private String headerParameterHost = getProperty("headerParameterHost");
    private String headerParameterHostValue = getProperty("hostValue");
    private String currentWeatherPath = getProperty("currentPath");
    private String lat = getProperty("lat");
    private String lon = getProperty("lon");

    public RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseRapidAPIUri)
            .addHeader(headerParameterKey, headerParameterKeyValue)
            .addHeader(headerParameterHost, headerParameterHostValue)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build();

    public List<CurrentWeatherDataPojo> getCurrentWeather(){
        return given().spec(requestSpec).log().all()
                        .basePath(currentWeatherPath)
                        .queryParam("lat", lat)
                        .and()
                        .queryParam("lon", lon)
                        .when()
                        .get()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and()
                .extract().body().jsonPath().getList("data", CurrentWeatherDataPojo.class);
    }
}