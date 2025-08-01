import React, { useState } from "react";

function BlogDetails() {
  const [showInstall, setShowInstall] = useState(true);

  return (
    <div className="panel">
      <h2>Blog Details</h2>
      <div style={{ marginBottom: 15 }}>
        <b>React Learning</b> <br />
        <span style={{ fontWeight: 600 }}>Stephen Biz</span> <br />
        <span>Welcome to learning React!</span>
      </div>
      {showInstall && (
        <div>
          <b>Installation</b>
          <br />
          <span style={{ fontWeight: 600 }}>Schwezdneier</span>
          <br />
          <span>You can install React from npm.</span>
        </div>
      )}
      <div style={{ marginTop: 12 }}>
        <button onClick={() => setShowInstall((v) => !v)}>
          {showInstall ? "Hide Installation" : "Show Installation"}
        </button>
      </div>
      {/* Example: Show another blog only if a variable is true (demonstrate advanced conditionals) */}
    </div>
  );
}

export default BlogDetails;
