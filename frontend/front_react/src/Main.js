import React from 'react';
import MenuTemplate from './MenuTemplate';
import Home from './Home';
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";

const Main = () => {
    return (
        <div>

        <Routes>
            <Route path="/" exact={true} element={<Home/>} />
            <Route path="/menuTemplate" exact={true} element={<MenuTemplate/>} />
        </Routes>

        </div>
    )
}

export default Main;