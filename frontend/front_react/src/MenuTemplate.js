import React from 'react';
import './MenuTemplate.css'
const MenuTemplate = () => {
    return (
        <div className="menu-template">

            <label className="text-label">
                메뉴코드 :
            </label>
                 <input type='text' name='menuCode' className="input-text"/>
            <br/>
            <label className="text-label">
                Alias :
            </label>
            <input type='text' name='alias' className="input-text"/>

            <br/>
            <label className="text-label">
            MenuLangPack:
            </label>
            <input type='text' name='menuLangPack' className="input-text"/>
        </div>
    )
}

export default MenuTemplate;