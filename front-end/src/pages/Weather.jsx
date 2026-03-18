import React, { useEffect, useState } from "react";
import { getWeather } from "../services/weatherService";
import MemeCard from "../components/MemeCard";
import { useAuth } from "../context/AuthContext";

function Weather() {
    const { user, logout } = useAuth();

    const [city, setCity] = useState("Moscow");
    const [weatherData, setWeatherData] = useState(null);

    const fetchWeather = async () => {
        try {
            const data = await getWeather(city);
            setWeatherData(data);
        } catch (err) {
            alert("Ошибка при получении погоды");
        }
    };

    useEffect(() => {
        fetchWeather();
    }, []);

    return (
        <div className="p-8">
            <h2 className="text-3xl font-bold mb-4">
                Привет, {user?.username}
            </h2>

            <div className="mb-4">
                <input
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                    className="border p-2 rounded mr-2"
                    placeholder="Введите город"
                />
                <button
                    onClick={fetchWeather}
                    className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
                >
                    Показать
                </button>
            </div>

            {weatherData && (
                <div className="flex flex-col items-center">
                    <h3 className="text-xl font-bold mb-2">
                        {weatherData.city}
                    </h3>
                    <p className="mb-4">
                        {weatherData.description},{" "}
                        {weatherData.temperature}°C
                    </p>
                    <MemeCard meme={weatherData.meme} />
                </div>
            )}
        </div>
    );
}

export default Weather;