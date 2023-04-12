package com.wechap.wechap.util;


import java.util.HashMap;
import java.util.Map;

public class WeatherUtil {
    // 받아온 날씨 정보를 한글로 번역(자동 번역은 너무 상태가 좋지 않아서 추가함)
    public String replace(String description){
        Map<String, String> map = new HashMap<>();

        map.put("thunderstorm with light rain", "가벼운 비를 동반한 천둥구름");
        map.put("thunderstorm with rain", "비를 동반한 천둥구름");
        map.put("thunderstorm with heavy rain", "폭우를 동반한 천둥구름");
        map.put("light thunderstorm", "약한 천둥구름");
        map.put("thunderstorm", "천둥구름");
        map.put("heavy thunderstorm", "강한 천둥구름");
        map.put("ragged thunderstorm", "불규칙적 천둥구름");
        map.put("thunderstorm with light drizzle", "약한 연무를 동반한 천둥구름");
        map.put("thunderstorm with drizzle", "연무를 동반한 천둥구름");
        map.put("thunderstorm with heavy drizzle", "강한 안개비를 동반한 천둥구름");
        map.put("light intensity drizzle", "가벼운 안개비");
        map.put("drizzle", "안개비");
        map.put("heavy intensity drizzle", "강한 안개비");
        map.put("light intensity drizzle rain", "가벼운 적은비");
        map.put("drizzle rain", "적은비");
        map.put("heavy intensity drizzle rain", "강한 적은비");
        map.put("shower rain and drizzle", "소나기와 안개비");
        map.put("heavy shower rain and drizzle", "강한 소나기와 안개비");
        map.put("shower drizzle", "소나기");
        map.put("light rain", "악한 비");
        map.put("moderate rain", "중간 비");
        map.put("heavy intensity rain", "강한 비");
        map.put("very heavy rain", "매우 강한 비");
        map.put("extreme rain", "극심한 비");
        map.put("freezing rain", "우박");
        map.put("light intensity shower rain", "약한 소나기 비");
        map.put("shower rain", "소나기 비");
        map.put("heavy intensity shower rain", "강한 소나기 비");
        map.put("ragged shower rain", "불규칙적 소나기 비");
        map.put("light snow", "가벼운 눈");
        map.put("snow", "눈");
        map.put("heavy snow", "강한 눈");
        map.put("sleet", "진눈깨비");
        map.put("shower sleet", "소나기 진눈깨비");
        map.put("light rain and snow", "약한 비와 눈");
        map.put("rain and snow", "비와 눈");
        map.put("light shower snow", "약한 소나기 눈");
        map.put("shower snow", "소나기 눈");
        map.put("heavy shower snow", "강한 소나기 눈");
        map.put("mist", "안개");
        map.put("smoke", "연기");
        map.put("haze", "연무");
        map.put("sand, dust whirls", "모래 먼지");
        map.put("fog", "안개");
        map.put("sand", "모래");
        map.put("dust", "먼지");
        map.put("volcanic ash", "화산재");
        map.put("squalls", "돌풍");
        map.put("tornado", "토네이도");
        map.put("clear sky", "구름 한 점 없는 맑은 하늘");
        map.put("few clouds", "약간의 구름이 낀 하늘");
        map.put("scattered clouds", "드문드문 구름이 낀 하늘");
        map.put("broken clouds", "구름이 거의 없는 하늘");
        map.put("overcast clouds", "구름으로 뒤덮인 흐린 하늘");
        map.put("tornado", "토네이도");
        map.put("tropical storm", "태풍");
        map.put("hurricane", "허리케인");
        map.put("cold", "한랭");
        map.put("hot", "고온");
        map.put("windy", "바람부는");
        map.put("hail", "우박");
        map.put("calm", "바람이 거의 없는");
        map.put("light breeze", "약한 바람");
        map.put("gentle breeze", "부드러운 바람");
        map.put("moderate breeze", "중간 세기 바람");
        map.put("fresh breeze", "신선한 바람");
        map.put("strong breeze", "센 바람");
        map.put("high win", "돌풍에 가까운 센 바람");
        map.put("gale", "돌풍");
        map.put("severe gale", "심각한 돌풍");
        map.put("storm", "폭풍");
        map.put("violent storm", "강한 폭풍");
        map.put("hurricane", "허리케인");

        String replacement = map.containsKey(description) ? map.get(description) : description;
        return replacement;
    }
}
