import { Navigate } from "react-router-dom";

function ProtectedRoute({ children, isAuthenticated, adminOnly, userRole }) {
    if (!isAuthenticated) return <Navigate to="/login" />;
    if (adminOnly && userRole !== "ROLE_ADMIN") return <Navigate to="/weather" />;
    return children;
}

export default ProtectedRoute;