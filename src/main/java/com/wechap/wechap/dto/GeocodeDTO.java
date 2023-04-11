package com.wechap.wechap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeocodeDTO {
    private String countryCode;
    private String country;
    private String city;
    private String district;
}
