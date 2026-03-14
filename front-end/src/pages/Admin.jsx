import React, { useEffect, useState } from "react";
import api from "../services/api";

export default function Admin() {
    const [memes, setMemes] = useState([]);

    const fetchMemes = async () => {
        const res = await api.get("/memes");
        setMemes(res.data);
    };

    const deleteMeme = async (id) => {
        await api.delete(`/memes/${id}`);
        fetchMemes();
    };

    useEffect(() => { fetchMemes(); }, []);

    return (
        <div>
            <h2>Admin Panel</h2>
            <ul>
                {memes.map(m => (
                    <li key={m.id}>
                        <img src={m.imageUrl} width={100} alt={m.description} />
                        <span>{m.description}</span>
                        <button onClick={() => deleteMeme(m.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}