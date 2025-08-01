import './App.css';
import ListOfPlayers from './components/ListOfPlayers';
import ScoreBelow70 from './components/ScoreBelow70';
import { OddPlayers } from './components/OddPlayers';
import { EvenPlayers } from './components/EvenPlayers';
import ListOfIndianPlayers from './components/ListOfIndianPlayers';

import { players, IndianPlayers } from './data';

function App() {
    const flag = true; // toggle true/false to test both views

    if (flag === true) {
        return (
            <div>
                <h1>List of Players</h1>
                <ListOfPlayers players={players} />
                <hr />
                <h1>List of Players having Scores Less than 70</h1>
                <ScoreBelow70 players={players} />
            </div>
        );
    } else {
        return (
            <div>
                <h1>Indian Team</h1>
                <h2>Odd Players</h2>
                <OddPlayers {...IndianPlayers} />
                <hr />
                <h2>Even Players</h2>
                <EvenPlayers {...IndianPlayers} />
                <hr />
                <h2>List of Indian Players Merged</h2>
                <ListOfIndianPlayers IndianPlayers={IndianPlayers} />
            </div>
        );
    }
}
export default App;
