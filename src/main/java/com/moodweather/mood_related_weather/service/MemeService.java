package com.moodweather.mood_related_weather.service;

import com.moodweather.mood_related_weather.dto.MemeDto;
import com.moodweather.mood_related_weather.entity.Meme;
import com.moodweather.mood_related_weather.repository.MemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemeService {

    private final MemeRepository memeRepository;

    public List<MemeDto> getAllMemes() {
        return memeRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    private MemeDto toDto(Meme meme) {
        return MemeDto.builder()
                .id(meme.getId())
                .imageUrl(meme.getImageUrl())
                .description(meme.getDescription())
                .weatherType(meme.getWeatherType())
                .rating(meme.getRating())
                .build();
    }
}
