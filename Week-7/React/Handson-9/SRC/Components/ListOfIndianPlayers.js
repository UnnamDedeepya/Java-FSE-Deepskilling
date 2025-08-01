function ListOfIndianPlayers({ IndianPlayers }) {
    return (
        <ul>
            {IndianPlayers.map((name, index) => (
                <li key={index}>{name}</li>
            ))}
        </ul>
    );
}
export default ListOfIndianPlayers;
