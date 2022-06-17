import React from "react";
import './App.css';
import PostCreate from "./pages/PostCreate";

export const App = () => { 
  return (
    <div className="container">
      <h1>Tech Challange!</h1>
      <PostCreate />
    </div>
  );
};
