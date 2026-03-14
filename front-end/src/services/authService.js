import api from "./api";

export const login = async (email, password) => {
    const res = await api.post("/auth/login", { email, password });
    localStorage.setItem("token", res.data.token);
    return res.data;
};

export const register = async (username, email, password) => {
    return await api.post("/auth/register", { username, email, password });
};

export const logout = () => {
    localStorage.removeItem("token");
};