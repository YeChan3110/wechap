package com.wechap.wechap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wechap.wechap.dto.GeocodeDTO;
import com.wechap.wechap.service.MapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("map")
public class MapController {

    private MapService mapService;

    @GetMapping("getAdress")
    public String getAdress(Model model) throws JsonProcessingException {
        GeocodeDTO geocodeDto = mapService.getAdress();

        model.addAttribute("country",geocodeDto.getCountry());
        model.addAttribute("city",geocodeDto.getCity());
        model.addAttribute("district",geocodeDto.getDistrict());

        return "recommend/weather";
    }
}
