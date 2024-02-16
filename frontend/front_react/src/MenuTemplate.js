import React, {useState} from 'react';
import './MenuTemplate.css'
import GridComponent from "./GridComponent";
const MenuTemplate = () => {
    const [panelAlias, setPanelAlias] = useState('');
    const [panelURL, setPanelURL] = useState('');
    const [panelAuthID, setPanelAuthID] = useState('');
    const [panelLangPack, setPanelLangPack] = useState('');
    const [comboBoxes, setComboBoxes] = useState([]);
    const sendData = async () => {
        const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;
        const payload = {
            panelAlias : panelAlias,
            panelURL : panelURL,
            panelAuthID : panelAuthID,
            panelLangPack : panelLangPack,
            gridItems : comboBoxes.map(comboBox => ({
                menuCode: comboBox.menuCode,
                menuLangPack: comboBox.menuLangPack,
                region : comboBox.region
            }))
        };
            fetch(`${serverUrl}/createMenuTemplate`,{
                method : 'POST',
                headers : {
                    'Content-Type' : 'application/json'
                },
                body: JSON.stringify(payload)
            })
                .then(response => response.blob())
                .then(blob => {
                const url = window.URL.createObjectURL(blob)
                const a   = document.createElement('a');
                a.style.display = 'none';
                a.href = url;
                a.download = 'example.zip';
                document.body.appendChild(a);
                a.click();
                window.URL.revokeObjectURL(url);
            })
                . catch(err => console.error('파일 다운로드 중 문제가 발생했습니다:', err));

    }


    const addComboBox = () => {
        const newComboBox = { id: comboBoxes.length + 1, name: `ComboBox ${comboBoxes.length + 1}` };
        setComboBoxes([...comboBoxes, newComboBox]);
    }
    const handleUpdate = (id, data) => {
        // id를 사용하여 comboBoxes 배열에서 해당 컴포넌트를 찾고 데이터를 업데이트
        setComboBoxes(comboBoxes.map(combo => combo.id === id ? {...combo, ...data} : combo));
    };
    return (
        <div className="menu-template">
                        <label className="text-label">
                panelAuthID :
            </label>
            <input
                type='text'
                name='panelAuthID'
                className="input-text"
                value={panelAuthID}
                onChange={e => {setPanelAuthID(e.target.value)}}/>
            <br/>
            <label className="text-label">
                panelAlias :
            </label>
            <input
                type='text'
                name='panelAlias'
                className="input-text"
                value={panelAlias}
                onChange={e => {setPanelAlias(e.target.value)}}/>
            <br/>
            <label className="text-label">
                panelLangPack:
            </label>
            <input
                type='text'
                name='panelLangPack'
                className="input-text"
                value={panelLangPack}
                onChange={e => {setPanelLangPack(e.target.value)}} />
            <br/>
            <label className="text-label">
                panelURL:
            </label>
            <input
                type='text'
                name='panelURL'
                className="input-text"
                value={panelURL}
                onChange={e => {setPanelURL(e.target.value)}}/>
            <br/>
            <button onClick={addComboBox}>콤보박스 추가</button>

            <div className="menu-template">
                <button onClick={addComboBox}>콤보박스 추가</button>
                {comboBoxes.map(comboBox => (
                    <GridComponent key={comboBox.id} id={comboBox.id} onUpdate={(data) => {
                        handleUpdate(comboBox.id, data)

                    }}/>
                ))}
                {/* 기타 필요한 UI 및 로직 */}
            </div>
            <button onClick={sendData}>
                sendData
            </button>
        </div>
    )
}

export default MenuTemplate;