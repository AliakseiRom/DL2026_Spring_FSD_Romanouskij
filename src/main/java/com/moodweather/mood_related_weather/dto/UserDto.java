package com.moodweather.mood_related_weather.dto;

import com.moodweather.mood_related_weather.util.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private Role role;

    public UserDto(Long id, String username, String email, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
