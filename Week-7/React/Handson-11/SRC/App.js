import React from "react";
import Counter from "./components/Counter";
import CurrencyConvertor from "./components/CurrencyConvertor";

function App() {
  return (
    <div style={{ marginLeft: "5%", marginTop: "20px" }}>
      <Counter />
      <br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
