import React from "react";
import "./App.css";
import officeImg from './office.png';
function App() {
  const offices = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "WeWork", Rent: 75000, Address: "Bangalore" },
    { Name: "Regus", Rent: 45000, Address: "Hyderabad" }
  ];

  const getRentClass = (rent) => rent <= 60000 ? "textRed" : "textGreen";

  return (
    <div style={{ marginLeft: "10%", marginTop: "30px" }}>
      <h1><b>Office Space , at Affordable Range</b></h1>
      <img src={officeImg} width="50%" height="50%" alt="Office Space"/>
      {offices.map((item, idx) => (
        <div key={idx}>
          <h1>Name: {item.Name}</h1>
          <h3 className={getRentClass(item.Rent)}>
            Rent: Rs. {item.Rent}
          </h3>
          <h3>Address: {item.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;
