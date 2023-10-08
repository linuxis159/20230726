import React from 'react';
import './LeftSide.css';
import {BrowserRouter, Link} from "react-router-dom";
const Navigation = () => {
    return (

    <ul className="navigation">
        <li><Link to="/">홈</Link></li>
        <li><Link to="/menuTemplate">메뉴생성</Link></li>
        <li><Link to="/popTemplate">팝업생성</Link></li>
        <li><Link to="/write/document">문서추가</Link></li>
        <li></li>
    </ul>

    );
};
const LeftSide = () => {
    return (
        <div className="left-side">
            <Navigation/>
        </div>
    )
}
export default LeftSide;