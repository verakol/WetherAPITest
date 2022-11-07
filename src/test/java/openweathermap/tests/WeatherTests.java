package openweathermap.tests;

import com.testapi.openweathermap.controller.WeatherController;
import com.testapi.openweathermap.pojo.RootWeatherInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.testapi.Utils.getProperty;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class WeatherTests extends WeatherController {

    private WeatherController controller;
    private String expectedCity = getProperty("city");
    private String expectedCityByID = getProperty("cityByID");
    private String expectedCityByZipCode = getProperty("cityByZipCode");
    private String lat = getProperty("lat");
    private String lon = getProperty("lon");

    @BeforeMethod
    public void setUp(){controller = new WeatherController();}

    @Test
    public void getWeatherByCityName(){
        List<RootWeatherInfo> weatherData = controller.getWeatherDataByCityName();
        assertThat(weatherData.size(),greaterThan(0));

        String actualCity = weatherData.get(0).getName();
        assertThat("City names are equal", actualCity.equalsIgnoreCase(expectedCity));
    }

    @Test
    public void getWeatherWithUnitsMetricCheckJSONSchemaValidation(){
        List<RootWeatherInfo> weatherInfo = controller.getWeatherWithUnitsMetric();
       assertThat("Weather data list is empty)", weatherInfo.size(), greaterThan(0));
    }

    @Test
    public void getWeatherInfoByCityID(){
        List<RootWeatherInfo> weatherData = controller.getWeatherByCityID();
        assertThat(weatherData.size(),greaterThan(0));
        String actualCityName = weatherData.get(0).getName();
        assertThat("Actual city name doesn't match with ID", actualCityName.equalsIgnoreCase(expectedCityByID));
    }

    @Test
    public void getWeatherInfoByCoordinates(){
        List<RootWeatherInfo> weatherData = controller.getWeatherByCoordinates();
        assertThat(weatherData.size(),greaterThan(0));
        String actualLonCoordinate = String.valueOf(weatherData.get(0).getCoord().getLon());
        String actualLatCoordinate = String.valueOf(weatherData.get(0).getCoord().getLat());
        assertThat("Actual lat coordinate doesn't match expected one", actualLonCoordinate.equals(lon));
        assertThat("Actual lat coordinate doesn't match expected one", actualLatCoordinate.equals(lat));
    }

    @Test
    public void getWeatherInfoByZipCode(){
        List<RootWeatherInfo> weatherData = controller.getWeatherByZipCode();
        assertThat(weatherData.size(),greaterThan(0));
        String actualCityName = weatherData.get(0).getName();
        assertThat("Actual city name doesn't match with ID", actualCityName.equalsIgnoreCase(expectedCityByZipCode));
    }
}