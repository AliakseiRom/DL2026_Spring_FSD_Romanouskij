import { Navigate } from "react-router-dom";
import { getRoleFromToken } from "../utils/auth";

export default function AdminRoute({ children }) {

    const role = getRoleFromToken();

    if (role !== "ROLE_ADMIN") {
        return <Navigate to="/weather" />;
    }

    return children;
}