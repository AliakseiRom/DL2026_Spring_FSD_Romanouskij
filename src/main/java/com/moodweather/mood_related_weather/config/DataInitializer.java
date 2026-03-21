package com.moodweather.mood_related_weather.config;


import com.moodweather.mood_related_weather.entity.Meme;
import com.moodweather.mood_related_weather.entity.User;
import com.moodweather.mood_related_weather.repository.MemeRepository;
import com.moodweather.mood_related_weather.repository.UserRepository;
import com.moodweather.mood_related_weather.util.Role;
import com.moodweather.mood_related_weather.util.WeatherType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemeRepository memeRepository;

    @Override
    public void run(String... args) {

        if (userRepository.findByUsername("admin").isEmpty()) {

            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@mail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);

            System.out.println("Admin user created");
        }

        if (memeRepository.count() == 0) {

            memeRepository.save(Meme.builder()
                    .imageUrl("When it rains and you forgot umbrella")
                    .description("https://i.imgflip.com/30b1gx.jpg")
                    .rating(5)
                    .weatherType(WeatherType.RAIN)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Rain outside but still need to go to work")
                    .description("https://i.imgflip.com/1bij.jpg")
                    .rating(4)
                    .weatherType(WeatherType.RAIN)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Rain mood activated")
                    .description("https://i.imgflip.com/26am.jpg")
                    .rating(4)
                    .weatherType(WeatherType.RAIN)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("When it is 35°C outside")
                    .description("https://i.imgflip.com/3si4.jpg")
                    .rating(5)
                    .weatherType(WeatherType.HOT)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Summer heat destroying productivity")
                    .description("https://i.imgflip.com/2fm6x.jpg")
                    .rating(4)
                    .weatherType(WeatherType.HOT)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("AC is my best friend now")
                    .description("https://i.imgflip.com/4acd7j.jpg")
                    .rating(4)
                    .weatherType(WeatherType.HOT)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Cold outside, staying inside forever")
                    .description("https://i.imgflip.com/9ehk.jpg")
                    .rating(5)
                    .weatherType(WeatherType.COLD)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("When winter hits suddenly")
                    .description("https://i.imgflip.com/1ur9b0.jpg")
                    .rating(4)
                    .weatherType(WeatherType.COLD)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Need 5 blankets")
                    .description("https://i.imgflip.com/3lmzyx.jpg")
                    .rating(4)
                    .weatherType(WeatherType.COLD)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("First snow excitement")
                    .description("https://i.imgflip.com/1otk96.jpg")
                    .rating(5)
                    .weatherType(WeatherType.SNOW)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Snowball fight mode")
                    .description("https://i.imgflip.com/4t0m5.jpg")
                    .rating(4)
                    .weatherType(WeatherType.SNOW)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Walking in snow like a penguin")
                    .description("https://i.imgflip.com/2wifvo.jpg")
                    .rating(4)
                    .weatherType(WeatherType.SNOW)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Wind destroying your hairstyle")
                    .description("https://i.imgflip.com/1g8my4.jpg")
                    .rating(4)
                    .weatherType(WeatherType.WIND)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Trying to walk in strong wind")
                    .description("https://i.imgflip.com/2gnnjh.jpg")
                    .rating(4)
                    .weatherType(WeatherType.WIND)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Wind vs umbrella battle")
                    .description("https://i.imgflip.com/3oevdk.jpg")
                    .rating(4)
                    .weatherType(WeatherType.WIND)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Cloudy mood activated")
                    .description("https://i.imgflip.com/2kbn1e.jpg")
                    .rating(3)
                    .weatherType(WeatherType.CLOUDY)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Perfect weather for coffee")
                    .description("https://i.imgflip.com/1jwhww.jpg")
                    .rating(4)
                    .weatherType(WeatherType.CLOUDY)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Clouds everywhere")
                    .description("https://i.imgflip.com/3pnmg.jpg")
                    .rating(3)
                    .weatherType(WeatherType.CLOUDY)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Sunny day happiness")
                    .description("https://i.imgflip.com/1bhk.jpg")
                    .rating(5)
                    .weatherType(WeatherType.CLEAR)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("Sunshine and good vibes")
                    .description("https://i.imgflip.com/3vzej.jpg")
                    .rating(5)
                    .weatherType(WeatherType.CLEAR)
                    .build());
        }
    }
}