package com.moodweather.mood_related_weather.service;

import com.moodweather.mood_related_weather.dto.MemeDto;
import com.moodweather.mood_related_weather.entity.Meme;
import com.moodweather.mood_related_weather.repository.MemeRepository;
import com.moodweather.mood_related_weather.util.WeatherType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MemeService {

    private final MemeRepository memeRepository;

    private final Random random = new Random();

    public List<MemeDto> getAllMemes() {

        return memeRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public List<MemeDto> getMemesByWeather(WeatherType weatherType) {

        return memeRepository.findByWeatherType(weatherType).stream()
                .map(this::toDto)
                .toList();
    }

    public MemeDto getRandomMemeByWeather(WeatherType weatherType) {

        List<Meme> memes = memeRepository.findByWeatherType(weatherType);

        if (memes.isEmpty()) {
            throw new RuntimeException("No memes for weather type: " + weatherType);
        }

        Meme meme = memes.get(random.nextInt(memes.size()));

        return toDto(meme);
    }

    public MemeDto addMeme(MemeDto memeDto) {
        Meme meme = Meme.builder()
                .imageUrl(memeDto.getImageUrl())
                .description(memeDto.getDescription())
                .weatherType(memeDto.getWeatherType())
                .rating(memeDto.getRating())
                .build();

        Meme savedMeme = memeRepository.save(meme);
        return toDto(savedMeme);
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
