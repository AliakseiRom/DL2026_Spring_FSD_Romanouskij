package com.moodweather.mood_related_weather.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
