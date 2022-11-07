package com.testapi.openweathermap.controller;

import com.testapi.openweathermap.pojo.RootWeatherInfo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static com.testapi.Utils.getProperty;
import static io.restassured.RestAssured.given;

public class WeatherController {

    private String baseOpenWeatherUri = getProperty("baseOpenWeatherUri");
    private String APIKey = getProperty("openWeatherAPIKey");
    private String openWeatherPath = getProperty("openWeatherPath");
    private String lat = getProperty("lat");
    private String lon = getProperty("lon");
    private String city = getProperty("city");
    private String cityID = getProperty("cityID");
    private String zipCode = getProperty("zipCode");
    private String countryCode = getProperty("countryCode");

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseOpenWeatherUri)
            .setBasePath(openWeatherPath)
            .setContentType(ContentType.JSON)
            .build();

    public List<RootWeatherInfo> getWeatherDataByCityName(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .queryParam("q", city)
                .and()
                .queryParam("appid", APIKey)
                .when()
                .get()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().body().as(RootWeatherInfo.class));
    }

    public List<RootWeatherInfo> getWeatherWithUnitsMetric(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .queryParam("q", city)
                .and()
                .queryParam("appid", APIKey)
                .and()
                .queryParam("units", "metric")
                .when()
                .get()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
                .extract().response().as(RootWeatherInfo.class));
    }

    public List<RootWeatherInfo> getWeatherByCityID(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .queryParam("id", cityID)
                .and()
                .queryParam("appid", APIKey)
                .when()
                .get()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(RootWeatherInfo.class));
    }

    public List<RootWeatherInfo> getWeatherByCoordinates(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .queryParam("lat", lat)
                .and()
                .queryParam("lon", lon)
                .and()
                .queryParam("appid", APIKey)
                .when()
                .get()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(RootWeatherInfo.class));
    }

    public List<RootWeatherInfo> getWeatherByZipCode(){
        return Arrays.asList(given().spec(requestSpec).log().all()
                .queryParam("zip", zipCode,countryCode)
                .and()
                .queryParam("appid", APIKey)
                .when()
                .get()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(RootWeatherInfo.class));
    }
}
