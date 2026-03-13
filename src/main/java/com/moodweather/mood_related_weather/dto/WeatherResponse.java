package com.moodweather.mood_related_weather.dto;

import lombok.Data;

@Data
public class WeatherResponse {

    private String city;
    private double temperature;
    private String description;
    private MemeDto meme;

}
