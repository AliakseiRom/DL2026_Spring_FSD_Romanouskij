import { Link, Outlet } from "react-router-dom";
import { useAuth } from "./context/AuthContext";

function App() {
    const { user, logout } = useAuth();

    return (
        <div>
            <h1 className="text-3xl font-bold text-center mt-4">Mood Weather</h1>

            <nav className="flex justify-center gap-4 mt-4">
                <Link to="/login">Login</Link>
                <Link to="/register">Register</Link>
                <Link to="/weather">Weather</Link>
                <Link to="/admin">Admin</Link>
                {user && (
                    <button
                        onClick={logout}
                        className="bg-red-500 text-white px-3 py-1 rounded"
                    >
                        Logout
                    </button>
                )}
            </nav>

            <div className="mt-6">
                <Outlet />
            </div>
        </div>
    );
}

export default App;