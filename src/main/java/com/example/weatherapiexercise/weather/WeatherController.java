package com.example.weatherapiexercise.weather;

import com.example.weatherapiexercise.model.WeatherData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/weather")
    public String showWeatherStats(@RequestParam String city, Model model) {

        Optional<WeatherData> weatherData = weatherService.getWeatherData(city);

        if (weatherData.isPresent()) {
            model.addAttribute("weatherData", weatherData.get());
            return "weather";
        } else {
            return "redirect:/";
        }
    }
}
