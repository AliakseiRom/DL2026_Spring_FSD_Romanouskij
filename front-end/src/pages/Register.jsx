import React, { useState } from "react";
import {Link, useNavigate} from "react-router-dom";
import { register } from "../services/authService";

export default function Register() {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await register(username, email, password);
            navigate("/login");
        } catch (err) {
            alert("Registration failed");
        }
    };

    return (
        <div className="flex items-center justify-center h-screen bg-gray-100">
            <form onSubmit={handleSubmit} className="bg-white p-8 rounded-xl shadow-md w-96">
                <h2 className="text-2xl font-bold mb-6 text-center text-black">Register</h2>

                <input
                    placeholder="Username"
                    className="w-full border p-2 rounded mb-4"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />

                <input
                    type="email"
                    placeholder="Email"
                    className="w-full border p-2 rounded mb-4"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />

                <input
                    type="password"
                    placeholder="Password"
                    className="w-full border p-2 rounded mb-6"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />

                <button className="w-full bg-blue-500 text-white p-2 rounded hover:bg-blue-600">
                    Register
                </button>

                <p className="text-center mt-4 text-sm">
                    Уже есть аккаунт?{" "}
                    <Link className="text-blue-500" to="/login">
                        Войти
                    </Link>
                </p>
            </form>
        </div>
    );
}