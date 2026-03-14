import React from "react";

export default function WeatherCard({ weather }) {
    return (
        <div>
            <h3>{weather.city}</h3>
            <p>Temperature: {weather.temperature}°C</p>
            <p>{weather.description}</p>
            {weather.meme && (
                <div>
                    <img src={weather.meme.imageUrl} alt={weather.meme.description} width={200} />
                    <p>{weather.meme.description}</p>
                </div>
            )}
        </div>
    );
}