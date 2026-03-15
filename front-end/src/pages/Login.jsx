import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { login } from "../services/authService";

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [auth, setAuth] = useState(null);
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const token = await login(username, password);
            setAuth({ token, username });
            navigate("/weather");
        } catch (err) {
            if (err.response) {
                console.log("Server responded:", err.response);
            } else if (err.request) {
                console.log("No response, request sent:", err.request);
            } else {
                console.log("Error", err.message);
            }
            alert("Login failed");
        }
    };

    return (
        <div className="flex items-center justify-center h-screen bg-gray-100">
            <form onSubmit={handleSubmit} className="bg-white p-8 rounded-xl shadow-md w-96">
                <h2 className="text-2xl font-bold mb-6 text-center">Login</h2>
                <input
                    placeholder="Username"
                    className="w-full border p-2 rounded mb-4"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <input
                    type="password"
                    placeholder="Password"
                    className="w-full border p-2 rounded mb-4"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button className="w-full bg-blue-500 text-white p-2 rounded hover:bg-blue-600">Login</button>
                <p className="text-center mt-4 text-sm">
                    Нет аккаунта? <Link className="text-blue-500" to="/register">Зарегистрироваться</Link>
                </p>
            </form>
        </div>
    );
}

export default Login;