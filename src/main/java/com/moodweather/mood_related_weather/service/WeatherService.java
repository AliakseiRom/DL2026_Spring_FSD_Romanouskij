package com.moodweather.mood_related_weather.service;

import com.moodweather.mood_related_weather.dto.MemeDto;
import com.moodweather.mood_related_weather.dto.OpenWeatherDto;
import com.moodweather.mood_related_weather.dto.WeatherResponse;
import com.moodweather.mood_related_weather.util.WeatherType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final MemeService memeService;

    @Value("${openweather.api.key}")
    private String apiKey;

    private RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeather(String city) {

        String url =
                "https://api.openweathermap.org/data/2.5/weather?q=" +
                        city +
                        "&appid=" +
                        apiKey +
                        "&units=metric";

        OpenWeatherDto response =
                restTemplate.getForObject(url, OpenWeatherDto.class);

        WeatherType type = mapWeather(response.getWeather().get(0).getMain());

        MemeDto meme = memeService.getRandomMemeByWeather(type);

        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCity(city);
        weatherResponse.setTemperature(response.getMain().getTemp());
        weatherResponse.setDescription(response.getWeather().get(0).getDescription());
        weatherResponse.setMeme(meme);

        return weatherResponse;
    }

    private WeatherType mapWeather(String weather) {

        return switch (weather.toUpperCase()) {

            case "RAIN", "DRIZZLE", "THUNDERSTORM" -> WeatherType.RAIN;
            case "SNOW" -> WeatherType.SNOW;
            case "CLEAR" -> WeatherType.CLEAR;
            case "CLOUDS" -> WeatherType.CLOUDY;
            case "MIST", "FOG", "HAZE" -> WeatherType.CLOUDY;

            default -> WeatherType.CLEAR;
        };
    }
}
