import React from "react";
import { Link } from "react-router-dom";

function App() {
    const token = localStorage.getItem("token");
  return (
      <div>
        <h1>Mood Weather</h1>
          <nav>
              <Link to="/login">Login</Link> |
              <Link to="/register">Register</Link> |
              <Link to="/weather">Weather</Link> |
              <Link to="/admin">Admin</Link> |
              {token && <button onClick={logout}>Logout</button>}
          </nav>
      </div>
  );
}

const logout = () => {
    localStorage.removeItem("token");
    window.location.href = "/login";
};

export default App;