import React from "react";
import { Navigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext.jsx";

/**
 * ProtectedRoute проверяет авторизацию и (опционально) роль пользователя
 * @param {ReactNode} children - компонент, который нужно отрендерить
 * @param {string} role - если указано, проверяет роль пользователя
 */
const ProtectedRoute = ({ children, role }) => {
    const { user } = useAuth();

    // Если пользователь не авторизован, редирект на /login
    if (!user) {
        return <Navigate to="/login" replace />;
    }

    // Если указана роль и она не совпадает с ролью пользователя, редирект на /
    if (role && user.role !== role) {
        return <Navigate to="/" replace />;
    }

    // Иначе показываем компонент
    return children;
};

export default ProtectedRoute;