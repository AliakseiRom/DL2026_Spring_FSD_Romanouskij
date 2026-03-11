TRUNCATE TABLE memes RESTART IDENTITY;

INSERT INTO memes (image_url, description, weather_type, rating) VALUES
                                                                     ('https://i.imgflip.com/30b1gx.jpg', 'When it rains and you forgot umbrella', 'RAIN', 5),
                                                                     ('https://i.imgflip.com/1bij.jpg', 'Rain outside but still need to go to work', 'RAIN', 4),
                                                                     ('https://i.imgflip.com/26am.jpg', 'Rain mood activated', 'RAIN', 4),

                                                                     ('https://i.imgflip.com/3si4.jpg', 'When it is 35°C outside', 'HOT', 5),
                                                                     ('https://i.imgflip.com/2fm6x.jpg', 'Summer heat destroying productivity', 'HOT', 4),
                                                                     ('https://i.imgflip.com/4acd7j.jpg', 'AC is my best friend now', 'HOT', 4),

                                                                     ('https://i.imgflip.com/9ehk.jpg', 'Cold outside, staying inside forever', 'COLD', 5),
                                                                     ('https://i.imgflip.com/1ur9b0.jpg', 'When winter hits suddenly', 'COLD', 4),
                                                                     ('https://i.imgflip.com/3lmzyx.jpg', 'Need 5 blankets', 'COLD', 4),

                                                                     ('https://i.imgflip.com/1otk96.jpg', 'First snow excitement', 'SNOW', 5),
                                                                     ('https://i.imgflip.com/4t0m5.jpg', 'Snowball fight mode', 'SNOW', 4),
                                                                     ('https://i.imgflip.com/2wifvo.jpg', 'Walking in snow like a penguin', 'SNOW', 4),

                                                                     ('https://i.imgflip.com/1g8my4.jpg', 'Wind destroying your hairstyle', 'WIND', 4),
                                                                     ('https://i.imgflip.com/2gnnjh.jpg', 'Trying to walk in strong wind', 'WIND', 4),
                                                                     ('https://i.imgflip.com/3oevdk.jpg', 'Wind vs umbrella battle', 'WIND', 4),

                                                                     ('https://i.imgflip.com/2kbn1e.jpg', 'Cloudy mood activated', 'CLOUDY', 3),
                                                                     ('https://i.imgflip.com/1jwhww.jpg', 'Perfect weather for coffee', 'CLOUDY', 4),
                                                                     ('https://i.imgflip.com/3pnmg.jpg', 'Clouds everywhere', 'CLOUDY', 3),

                                                                     ('https://i.imgflip.com/1bhk.jpg', 'Sunny day happiness', 'CLEAR', 5),
                                                                     ('https://i.imgflip.com/3vzej.jpg', 'Sunshine and good vibes', 'CLEAR', 5),
                                                                     ('https://i.imgflip.com/2odckz.jpg', 'Perfect weather for a walk', 'CLEAR', 4);