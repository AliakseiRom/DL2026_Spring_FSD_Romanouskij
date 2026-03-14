package com.moodweather.mood_related_weather.controller;

import com.moodweather.mood_related_weather.dto.WeatherResponse;
import com.moodweather.mood_related_weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}
