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
        <div>
            <h2>Register</h2>
            <form onSubmit={handleSubmit}>
                <input placeholder="Username" value={username} onChange={e => setUsername(e.target.value)} required/>
                <input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)}
                       required/>
                <input type="password" placeholder="Password" value={password}
                       onChange={e => setPassword(e.target.value)} required/>
                <button type="submit">Register</button>
            </form>

            <p>
                Уже есть аккаунт? <Link to="/login">Войти</Link>
            </p>
        </div>
    );
}