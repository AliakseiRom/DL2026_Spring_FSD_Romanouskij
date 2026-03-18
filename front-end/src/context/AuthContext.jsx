import { createContext, useContext, useEffect, useState } from "react";
import { jwtDecode } from "jwt-decode";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);

    useEffect(() => {
        const token = localStorage.getItem("token");

        if (token) {
            try {
                const decoded = jwtDecode(token);

                setUser({
                    username: decoded.sub,
                    role: decoded.role,
                    token
                });
            } catch (e) {
                console.error("Invalid token");
                logout();
            }
        }
    }, []);

    const loginUser = (token) => {
        const decoded = jwtDecode(token);

        const userData = {
            username: decoded.sub,
            role: decoded.role,
            token
        };

        localStorage.setItem("token", token);
        setUser(userData);
    };

    const logout = () => {
        localStorage.removeItem("token");
        setUser(null);
        window.location.href = "/login";
    };

    return (
        <AuthContext.Provider value={{ user, loginUser, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);