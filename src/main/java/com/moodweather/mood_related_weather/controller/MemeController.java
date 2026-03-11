package com.moodweather.mood_related_weather.controller;

import com.moodweather.mood_related_weather.dto.MemeDto;
import com.moodweather.mood_related_weather.service.MemeService;
import com.moodweather.mood_related_weather.util.WeatherType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/memes")
@RequiredArgsConstructor
public class MemeController {

    private final MemeService memeService;

    @GetMapping
    public List<MemeDto> getAllMemes() {
        return memeService.getAllMemes();
    }

    @GetMapping("/weather/{type}")
    public List<MemeDto> getMemesByWeather(@PathVariable WeatherType type) {
        return memeService.getMemesByWeather(type);
    }

    @GetMapping("/random/{type}")
    public MemeDto getRandomMeme(@PathVariable WeatherType type) {
        return memeService.getRandomMemeByWeather(type);
    }
}
