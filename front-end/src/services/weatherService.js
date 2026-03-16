import api from "./api";
import axios from "axios";

const API_URL = "http://localhost:8080/api";

export const getWeather = async (city) => {
    const res = await api.get(`/weather/${city}`);
    return res.data;
};

export const getRandomMeme = async (weatherType) => {
    const res = await api.get(`/memes/random/${weatherType}`);
    return res.data;
};

export const getAllMemes = async (token) => {
    const res = await axios.get(`${API_URL}/memes`, {
        headers: { Authorization: `Bearer ${token}` }
    });
    return res.data;
};

export const addMeme = async (meme, token) => {
    const res = await axios.post(`${API_URL}/memes`, meme, {
        headers: { Authorization: `Bearer ${token}` }
    });
    return res.data;
};

export const deleteMeme = async (memeId, token) => {
    const res = await axios.delete(`${API_URL}/memes/${memeId}`, {
        headers: { Authorization: `Bearer ${token}` }
    });
    return res.data;
};