package com.moodweather.mood_related_weather.controller;

import com.moodweather.mood_related_weather.dto.UserDto;
import com.moodweather.mood_related_weather.entity.User;
import com.moodweather.mood_related_weather.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
