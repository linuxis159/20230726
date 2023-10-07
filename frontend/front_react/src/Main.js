import React from 'react';
import MenuTemplate from './MenuTemplate';
import Home from './Home';
import Document from './Document';
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";
import WriteDocument from "./WriteDocument";

const Main = () => {
    return (
        <div>

        <Routes>
            <Route path="/" exact={true} element={<Home/>} />
            <Route path="/menuTemplate" exact={true} element={<MenuTemplate/>} />
            <Route path="/write/document" exact={true} element={<WriteDocument/>} />
            <Route path="/searchDoc/:docTitle" element={<Document/>} />
        </Routes>

        </div>
    )
}

export default Main;