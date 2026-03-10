package com.moodweather.mood_related_weather.repository;

import com.moodweather.mood_related_weather.entity.Meme;
import com.moodweather.mood_related_weather.util.WeatherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {

    List<Meme> findByWeatherType(WeatherType weatherType);
}
