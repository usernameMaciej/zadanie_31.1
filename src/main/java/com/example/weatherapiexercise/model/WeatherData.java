package com.example.weatherapiexercise.model;

import lombok.Data;

@Data
public class WeatherData {

    private Main main;
    private Wind wind;
    private String name;
}
