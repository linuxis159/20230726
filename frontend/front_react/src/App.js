import './App.css';
import {useState} from "react";
import LeftSide from './LeftSide';
import Main     from './Main';
import {BrowserRouter, Routes} from "react-router-dom";
function App() {

  return (
    <div className="App">
    <BrowserRouter>
      <LeftSide/>
        <Main/>
    </BrowserRouter>

    </div>
  );
}

export default App;
