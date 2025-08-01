import React, { useState } from "react";

function BookDetails() {
  const [showAll, setShowAll] = useState(false);

  // Example book data
  const books = [
    { name: "Master React", pages: 670 },
    { name: "Deep Dive into Angular 11", pages: 800 },
    { name: "Mongo Essentials", pages: 450 },
    { name: "Express Handbook", pages: 350 },
  ];

  return (
    <div className="panel">
      <h2>Book Details</h2>
      <ul>
        {books
          .filter((_, idx) => showAll || idx < 3) // Show 3 by default, all if toggled
          .map((book, idx) => (
            <li key={book.name}>
              <b>{book.name}</b> <br />
              <span>{book.pages}</span>
            </li>
          ))}
      </ul>
      <button style={{ marginTop: 10 }} onClick={() => setShowAll((v) => !v)}>
        {showAll ? "Show Fewer" : "Show All"}
      </button>
    </div>
  );
}

export default BookDetails;
