package com.wechap.wechap.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechap.wechap.dto.GeocodeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {

    @Value("${naver.appId}")
    private String apiId;
    @Value("${naver.appKey}")
    private String appKey;

    public GeocodeDTO getAdress() throws JsonProcessingException {
        double lon = 126.857308; // 경도
        double lat = 37.5548368; // 위도

        String endpoint = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc";

        RestTemplate restTemplate = new RestTemplate();
        // http 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID",apiId);
        headers.set("X-NCP-APIGW-API-KEY",appKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 요청 url
        String requestUrl = endpoint + "?coords=" + lon + "," + lat + "&request=coordsToaddr&orders=addr&output=json";

        // API 요청
        ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.GET, entity, String.class);
        String responseBody = response.getBody();

        // 응답 내용 추출
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(responseBody);
        JsonNode resultsNode = rootNode.path("results");
        JsonNode regionNode = resultsNode.path(0).path("region");

        // GeocodeDto 객체 생성
        String countryCode = regionNode.path("area1").path("code").asText();
        String country = regionNode.path("area1").path("name").asText();
        String city = regionNode.path("area2").path("name").asText();
        String district = regionNode.path("area3").path("name").asText();

        GeocodeDTO geocodeDto = new GeocodeDTO(countryCode, country, city, district);
        return geocodeDto;
    }
}
