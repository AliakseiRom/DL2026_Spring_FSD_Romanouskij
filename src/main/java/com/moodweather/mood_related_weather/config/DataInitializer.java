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
                    .imageUrl("https://i.imgflip.com/30b1gx.jpg")
                    .description("When it rains and you forgot umbrella")
                    .rating(5)
                    .weatherType(WeatherType.RAIN)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/1bij.jpg")
                    .description("Rain outside but still need to go to work")
                    .rating(4)
                    .weatherType(WeatherType.RAIN)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/26am.jpg")
                    .description("Rain mood activated")
                    .rating(4)
                    .weatherType(WeatherType.RAIN)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/3si4.jpg")
                    .description("When it is 35°C outside")
                    .rating(5)
                    .weatherType(WeatherType.HOT)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/2fm6x.jpg")
                    .description("Summer heat destroying productivity")
                    .rating(4)
                    .weatherType(WeatherType.HOT)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/4acd7j.jpg")
                    .description("AC is my best friend now")
                    .rating(4)
                    .weatherType(WeatherType.HOT)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/9ehk.jpg")
                    .description("Cold outside, staying inside forever")
                    .rating(5)
                    .weatherType(WeatherType.COLD)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/1ur9b0.jpg")
                    .description("When winter hits suddenly")
                    .rating(4)
                    .weatherType(WeatherType.COLD)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/3lmzyx.jpg")
                    .description("Need 5 blankets")
                    .rating(4)
                    .weatherType(WeatherType.COLD)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/1otk96.jpg")
                    .description("First snow excitement")
                    .rating(5)
                    .weatherType(WeatherType.SNOW)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/4t0m5.jpg")
                    .description("Snowball fight mode")
                    .rating(4)
                    .weatherType(WeatherType.SNOW)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/2wifvo.jpg")
                    .description("Walking in snow like a penguin")
                    .rating(4)
                    .weatherType(WeatherType.SNOW)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/1g8my4.jpg")
                    .description("Wind destroying your hairstyle")
                    .rating(4)
                    .weatherType(WeatherType.WIND)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/2gnnjh.jpg")
                    .description("Trying to walk in strong wind")
                    .rating(4)
                    .weatherType(WeatherType.WIND)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/3oevdk.jpg")
                    .description("Wind vs umbrella battle")
                    .rating(4)
                    .weatherType(WeatherType.WIND)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/2kbn1e.jpg")
                    .description("Cloudy mood activated")
                    .rating(3)
                    .weatherType(WeatherType.CLOUDY)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/1jwhww.jpg")
                    .description("Perfect weather for coffee")
                    .rating(4)
                    .weatherType(WeatherType.CLOUDY)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/3pnmg.jpg")
                    .description("Clouds everywhere")
                    .rating(3)
                    .weatherType(WeatherType.CLOUDY)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/1bhk.jpg")
                    .description("Sunny day happiness")
                    .rating(5)
                    .weatherType(WeatherType.CLEAR)
                    .build());

            memeRepository.save(Meme.builder()
                    .imageUrl("https://i.imgflip.com/3vzej.jpg")
                    .description("Sunshine and good vibes")
                    .rating(5)
                    .weatherType(WeatherType.CLEAR)
                    .build());
        }
    }
}