package com.moodweather.mood_related_weather.dto;

import com.moodweather.mood_related_weather.util.WeatherType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemeDto {

    private Long id;
    private String imageUrl;
    private String description;
    private WeatherType weatherType;
    private Integer rating;
}
