package com.wechap.wechap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wechap.wechap.dto.GeocodeDTO;
import com.wechap.wechap.dto.Weather2DTO;
import com.wechap.wechap.service.MapService;
import com.wechap.wechap.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private MapService mapService;

    @GetMapping("goWeather")
    public String getWeather(Model model) throws JsonProcessingException {
        // 도시는 naverMapsApi에서 받아온걸로 파라미터 수정할 것

        // 날씨 정보
        Weather2DTO weather2Dto = weatherService.getWeather("Seoul");

        model.addAttribute("temperature", weather2Dto.getTemp());
        model.addAttribute("description", weather2Dto.getDescription());
        model.addAttribute("time", weather2Dto.getFormattedTime());

        // 위도 경도로 주소
        GeocodeDTO geocodeDto = mapService.getAdress();

        model.addAttribute("country",geocodeDto.getCountry());
        model.addAttribute("city",geocodeDto.getCity());
        model.addAttribute("district",geocodeDto.getDistrict());

        return "recommend/weather";
    }

    // 아래 코드는 WeatherDTO에서 사용
    //        WeatherDTO weatherDto = weatherService.getWeather("Seoul");
    //        model.addAttribute("temperature", weatherDto.getMain().getTemp());
    //        model.addAttribute("description", weatherDto.getWeather().get(0).getDescription());
    //        model.addAttribute("icon", weatherDto.getWeather().get(0).getIcon());
}