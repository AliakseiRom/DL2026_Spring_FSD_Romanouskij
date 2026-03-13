package com.moodweather.mood_related_weather.dto;

import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherDto {

    private Main main;
    private List<Weather> weather;

    @Data
    public static class Main {
        private double temp;
    }

    @Data
    public static class Weather {
        private String main;
        private String description;
    }
}
