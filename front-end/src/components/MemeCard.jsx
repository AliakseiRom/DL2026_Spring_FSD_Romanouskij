function MemeCard({ meme }) {
    return (
        <div className="bg-white shadow rounded p-4 flex flex-col items-center">
            <img src={meme.imageUrl} alt={meme.description} className="w-64 h-64 object-cover rounded mb-2" />
            <p className="text-center font-medium">{meme.description}</p>
        </div>
    );
}

export default MemeCard;