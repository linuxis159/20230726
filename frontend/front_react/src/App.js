import './App.css';
import Header from './Header';
import LeftSide from './LeftSide';
import Main     from './Main';
import {BrowserRouter, Routes} from "react-router-dom";
function App() {

  return (
    <div className="App">
    <BrowserRouter>
      <Header/>
      <LeftSide/>
        <Main/>
    </BrowserRouter>

    </div>
  );
}

export default App;
