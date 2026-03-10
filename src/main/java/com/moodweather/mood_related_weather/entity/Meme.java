package com.moodweather.mood_related_weather.entity;

import com.moodweather.mood_related_weather.util.WeatherType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "memes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String description;

    @Enumerated(EnumType.STRING)
    private WeatherType weatherType;

    private Integer rating;

    private LocalDateTime createdAt;
}
