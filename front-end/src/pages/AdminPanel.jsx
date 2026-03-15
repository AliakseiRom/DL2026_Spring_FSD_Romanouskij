import { useEffect, useState } from "react";
import { getAllMemes, addMeme, deleteMeme } from "../services/weatherService";

function AdminPanel() {
    const [memes, setMemes] = useState([]);

    const fetchMemes = async () => {
        const data = await getAllMemes();
        setMemes(data);
    };

    useEffect(() => {
        fetchMemes();
    }, []);

    return (
        <div className="p-8">
            <h2 className="text-3xl font-bold mb-4">Админка</h2>
            <div className="grid grid-cols-3 gap-4">
                {memes.map((meme) => (
                    <div key={meme.id} className="bg-white p-2 rounded shadow">
                        <img src={meme.imageUrl} alt={meme.description} className="w-full h-48 object-cover mb-2" />
                        <p className="text-center">{meme.description}</p>
                        <button
                            className="bg-red-500 text-white px-2 py-1 rounded w-full mt-2 hover:bg-red-600"
                            onClick={() => deleteMeme(meme.id).then(fetchMemes)}
                        >
                            Удалить
                        </button>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default AdminPanel;