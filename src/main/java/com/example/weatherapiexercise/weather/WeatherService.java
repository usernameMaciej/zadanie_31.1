package com.example.weatherapiexercise.weather;

import com.example.weatherapiexercise.model.WeatherData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    public WeatherData getWeatherData(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid=bc58da24b22d817bc50cf3d72134877a&units=metric";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, WeatherData.class, city);
    }
}
