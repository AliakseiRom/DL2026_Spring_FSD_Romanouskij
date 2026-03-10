package com.moodweather.mood_related_weather.entity;

import com.moodweather.mood_related_weather.util.WeatherType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "memes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meme extends BaseEntity {

    private String imageUrl;

    private String description;

    @Enumerated(EnumType.STRING)
    private WeatherType weatherType;

    private Integer rating;
}
