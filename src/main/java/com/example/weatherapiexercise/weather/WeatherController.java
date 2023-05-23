package com.example.weatherapiexercise.weather;

import com.example.weatherapiexercise.model.WeatherData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/weather")
    public String getWeatherCity(@RequestParam String city, RedirectAttributes redirectAttributes) {

        WeatherData weatherData = weatherService.getWeatherData(city);

        if (weatherData != null) {
            redirectAttributes.addFlashAttribute("weatherData", weatherData);
            return "redirect:/weather";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/weather")
    public String showWeatherStats(Model model, WeatherData weatherData) {
        if (model.containsAttribute("weatherData")) {
            model.addAttribute("weatherData", weatherData);
            return "weather";
        } else {
            return "redirect:/";
        }
    }
}
