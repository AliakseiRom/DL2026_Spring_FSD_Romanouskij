package com.moodweather.mood_related_weather.controller;

import com.moodweather.mood_related_weather.dto.MemeDto;
import com.moodweather.mood_related_weather.entity.Meme;
import com.moodweather.mood_related_weather.repository.MemeRepository;
import com.moodweather.mood_related_weather.service.MemeService;
import com.moodweather.mood_related_weather.util.WeatherType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memes")
@RequiredArgsConstructor
public class MemeController {

    private final MemeService memeService;
    private final MemeRepository memeRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<MemeDto> getAllMemes() {
        return memeService.getAllMemes();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/weather/{type}")
    public List<MemeDto> getMemesByWeather(@PathVariable WeatherType type) {
        return memeService.getMemesByWeather(type);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/random/{type}")
    public MemeDto getRandomMeme(@PathVariable WeatherType type) {
        return memeService.getRandomMemeByWeather(type);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public MemeDto addMeme(@RequestBody MemeDto memeDto) {
        return memeService.addMeme(memeDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteMeme(@PathVariable Long id) {
        memeService.deleteMeme(id);
        return "meme deleted";
    }
}
