import { Link } from "react-router-dom";

function Navbar({ isAuthenticated, logout }) {
    return (
        <nav className="bg-blue-600 text-white p-4 flex justify-between">
            <div className="font-bold text-lg">Mood Weather</div>
            <div className="space-x-4">
                {isAuthenticated ? (
                    <>
                        <Link to="/weather" className="hover:underline">Weather</Link>
                        <Link to="/admin" className="hover:underline">Admin</Link>
                        <button onClick={logout} className="bg-red-500 px-3 py-1 rounded hover:bg-red-600">Logout</button>
                    </>
                ) : (
                    <>
                        <Link to="/login" className="hover:underline">Login</Link>
                        <Link to="/register" className="hover:underline">Register</Link>
                    </>
                )}
            </div>
        </nav>
    );
}

export default Navbar;