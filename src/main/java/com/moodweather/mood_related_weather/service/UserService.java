package com.moodweather.mood_related_weather.service;

import com.moodweather.mood_related_weather.dto.UserDto;
import com.moodweather.mood_related_weather.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserDto(
                        u.getId(),
                        u.getUsername(),
                        u.getEmail(),
                        u.getRole()
                ))
                .toList();
    }
}
