import React, { useState } from "react";
import { getWeather } from "../services/weatherService";
import WeatherCard from "../components/WeatherCard";

export default function Weather() {
    const [city, setCity] = useState("");
    const [data, setData] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const res = await getWeather(city);
        setData(res);
    };

    return (
        <div>
            <h2>Check Mood Weather</h2>
            <form onSubmit={handleSubmit}>
                <input placeholder="City" value={city} onChange={e => setCity(e.target.value)} required />
                <button type="submit">Get Weather</button>
            </form>
            {data && <WeatherCard weather={data} />}
        </div>
    );
}