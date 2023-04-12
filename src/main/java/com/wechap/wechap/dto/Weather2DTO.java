package com.wechap.wechap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Weather2DTO {
    private double temp;
    private String description;
    private String icon;
    private String formattedTime;
}
