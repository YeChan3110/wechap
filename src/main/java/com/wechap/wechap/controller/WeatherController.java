package com.wechap.wechap.controller;

import com.wechap.wechap.dto.WeatherDTO;
import com.wechap.wechap.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String getWeather(Model model) {
        WeatherDTO weatherDto = weatherService.getWeather("Seoul");

        model.addAttribute("temperature", weatherDto.getMain().getTemp());
        model.addAttribute("description", weatherDto.getWeather().get(0).getDescription());
        model.addAttribute("icon", weatherDto.getWeather().get(0).getIcon());

        return "recommend/weather";
    }
}