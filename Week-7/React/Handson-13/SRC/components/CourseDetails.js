import React, { useState } from "react";

function CourseDetails() {
  // Example of conditional rendering inside the component
  const [showReact, setShowReact] = useState(true);

  return (
    <div className="panel">
      <h2>Course Details</h2>
      <div>
        <b>Angular</b>
        <div>4/5/2021</div>
      </div>
      <div style={{ marginTop: 14 }}>
        <b>
          React{" "}
          <button
            onClick={() => setShowReact((r) => !r)}
            style={{ fontSize: "12px", marginLeft: 8 }}
          >
            {showReact ? "Hide" : "Show"}
          </button>
        </b>
        {showReact && <div>6/3/2021</div>}
      </div>
      {/* Example: more conditionals */}
      <div style={{ marginTop: 14 }}>
        <b>Vue</b>
        {/* Show only if today is an even date (demonstration of logic condition) */}
        {new Date().getDate() % 2 === 0 && <div>5/10/2024</div>}
      </div>
    </div>
  );
}

export default CourseDetails;
