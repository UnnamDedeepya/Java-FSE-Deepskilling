import React, { useState } from "react";
import CourseDetails from "./components/CourseDetails";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";

import "./App.css"; // We'll use this for simple flexbox styling

function App() {
  // Manage which sections are visible
  const [showCourses, setShowCourses] = useState(true);
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);

  return (
    <div>
      <h1 style={{ textAlign: "center", marginBottom: 30 }}>BloggerApp</h1>
      {/* Example: Toggle Sections (demonstrate conditional rendering) */}
      <div style={{ textAlign: "center", marginBottom: 10 }}>
        <button onClick={() => setShowCourses((v) => !v)}>
          {showCourses ? "Hide" : "Show"} Course Details
        </button>
        <button onClick={() => setShowBooks((v) => !v)} style={{ marginLeft: 12 }}>
          {showBooks ? "Hide" : "Show"} Book Details
        </button>
        <button onClick={() => setShowBlogs((v) => !v)} style={{ marginLeft: 12 }}>
          {showBlogs ? "Hide" : "Show"} Blog Details
        </button>
      </div>
      <div className="container">
        {showCourses && <CourseDetails />}
        {showBooks && <BookDetails />}
        {showBlogs && <BlogDetails />}
      </div>
    </div>
  );
}

export default App;
