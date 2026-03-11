package com.moodweather.mood_related_weather.controller;

import com.moodweather.mood_related_weather.dto.MemeDto;
import com.moodweather.mood_related_weather.service.MemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
}
