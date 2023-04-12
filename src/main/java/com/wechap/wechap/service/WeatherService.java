package com.wechap.wechap.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechap.wechap.dto.Weather2DTO;
import com.wechap.wechap.util.WeatherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;

@Service
public class WeatherService {
    @Value("${weather.appKey}")
    private String apiKey;

    public Weather2DTO getWeather(String city) throws JsonProcessingException {
        // 요청 url (한국어로 요청 시 &lang=kr 추가)
        // 아래 response는 WeatherDTO에 사용
        // ResponseEntity<WeatherDTO> response = restTemplate.getForEntity(url, WeatherDTO.class, city, apiKey);

        String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey+"&units=metric";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null,String.class);
        String responseBody = response.getBody();

        // 응답 내용 추출
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(responseBody);
        JsonNode weatherNode = rootNode.path("weather");
        JsonNode tempNode = rootNode.path("main");

        // WeatherDto 객체 생성
        double temp = tempNode.path("temp").asDouble();
        String description = weatherNode.path(0).path("description").asText();
        String icon = weatherNode.path(0).path("Oid").asText();
        int time = rootNode.path("timezone").asInt();

        // description 번역
        WeatherUtil weatherUtil = new WeatherUtil();
        description = weatherUtil.replace(description);

        // 시간 변환
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;
        String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        Weather2DTO weather2Dto = new Weather2DTO(temp, description, icon, formattedTime);

        return weather2Dto;
    }
}