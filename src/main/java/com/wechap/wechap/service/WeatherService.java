package com.wechap.wechap.service;

import com.wechap.wechap.dto.WeatherDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;

@Service
public class WeatherService {
    @Value("${weather.appKey}")
    private String apiKey;

    public WeatherDTO getWeather(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric&lang=kr";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherDTO> response = restTemplate.getForEntity(url, WeatherDTO.class, city, apiKey);

        return response.getBody();
    }
}