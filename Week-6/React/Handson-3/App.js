import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore
        Name="Dedeepya"
        School="Malla Reddy College"
        total={284}
        goal={3}
      />
    </div>
  );
}

export default App;
