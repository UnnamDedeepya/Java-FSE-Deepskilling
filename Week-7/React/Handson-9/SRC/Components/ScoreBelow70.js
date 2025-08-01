function ScoreBelow70({ players }) {
    const below70 = players.filter(p => p.score <= 70);

    return (
        <ul>
            {below70.map((p, i) => (
                <li key={i}>{p.name} - {p.score}</li>
            ))}
        </ul>
    );
}
export default ScoreBelow70;
