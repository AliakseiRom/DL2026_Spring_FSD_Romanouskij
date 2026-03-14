import React from "react";
import { Link } from "react-router-dom";

function App() {
  return (
      <div>
        <h1>Mood Weather</h1>
        <nav>
          <Link to="/login">Login</Link> |
          <Link to="/register">Register</Link> |
          <Link to="/weather">Weather</Link> |
          <Link to="/admin">Admin</Link>
        </nav>
      </div>
  );
}

export default App;