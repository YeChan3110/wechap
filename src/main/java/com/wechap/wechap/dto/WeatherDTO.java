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

    // getter, setter 생략

    public static class WeatherMainDto {
        private double temp;

        // getter, setter 생략

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }

    public static class WeatherInfoDto {
        private String description;
        private String icon;

        // getter, setter 생략

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}