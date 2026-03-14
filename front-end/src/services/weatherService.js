import api from "./api";

export const getWeather = async (city) => {
    const res = await api.get(`/weather/${city}`);
    return res.data;
};

export const getRandomMeme = async (weatherType) => {
    const res = await api.get(`/memes/random/${weatherType}`);
    return res.data;
};