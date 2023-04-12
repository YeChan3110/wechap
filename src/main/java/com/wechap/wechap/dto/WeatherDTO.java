package com.wechap.wechap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {
    private WeatherMainDto main;
    private List<WeatherInfoDto> weather;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class WeatherMainDto {
        private double temp;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class WeatherInfoDto {
        private String description;

        private String icon;
    }
}