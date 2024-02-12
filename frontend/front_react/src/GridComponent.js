import React, {useState} from 'react';
import Home from "./Home";
const GridComponent = ({ id, onUpdate }) => {
    const [menuCode, setMenuCode] = useState('');
    const [alias, setAlias] = useState('');
    const [menuLangPack, setMenuLangPack] = useState('');
    const [url, setUrl] = useState('');

    const handleChange = () => {
        // 여기서 모든 상태를 하나의 객체로 묶어서 전달
        onUpdate({ menuCode, alias, menuLangPack, url });
    };

    return (
        <div>
            <select>
                <option value="Grid">GRID</option>
                <option value="Tab">TAB</option>
                <option value="Container">Container</option>
                <option value="TabPanel">Container</option>
            </select>
            <br/>
            <select>
                <option value="LEFT">LEFT</option>
                <option value="RIGHT">RGIHT</option>
                <option value="TOP">TOP</option>
                <option value="BOTTOM">TOP</option>
            </select>
            <br/>
            <label className="text-label">
                메뉴코드 :
            </label>
            <input
                type='text'
                name='menuCode'
                className="input-text"
                value={menuCode}
                onChange={e => {setMenuCode(e.target.value); handleChange();}}/>
            <br/>
            <label className="text-label">
                Alias :
            </label>
            <input
                type='text'
                name='alias'
                className="input-text"
                value={alias}
                onChange={e => {setAlias(e.target.value); handleChange();}}/>
            <br/>
            <label className="text-label">
                MenuLangPack:
            </label>
            <input
                type='text'
                name='menuLangPack'
                className="input-text"
                value={menuLangPack}
                onChange={e => {setMenuLangPack(e.target.value); handleChange();}} />
            <br/>
            <label className="text-label">
                URL:
            </label>
            <input
                type='text'
                name='url'
                className="input-text"
                value={url}
                onChange={e => {setUrl(e.target.value); handleChange();}}/>
            <br/>
        </div>
    );
};
export default GridComponent;