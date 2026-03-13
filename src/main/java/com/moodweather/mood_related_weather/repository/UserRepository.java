package com.moodweather.mood_related_weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moodweather.mood_related_weather.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
