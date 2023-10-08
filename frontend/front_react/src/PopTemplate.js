import React, {useState} from 'react';


const PopTemplate = () => {
    const [alias, setAlias] = useState('');
    const [menuLangPack, setMenuLangPack] = useState('');
    const [url, setUrl] = useState('');
    const sendData = async () => {
        const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;

        fetch(`${serverUrl}/createPopTemplate`,{
            method : 'POST',
            headers : {
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify({
                alias,
                menuLangPack,
                url
            })
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
    return (
        <div className="menu-template">

            <label className="text-label">
                Alias :
            </label>
            <input
                type='text'
                name='alias'
                className="input-text"
                value={alias}
                onChange={e => setAlias(e.target.value)}/>



            <br/>
            <label className="text-label">
                MenuLangPack:
            </label>
            <input
                type='text'
                name='menuLangPack'
                className="input-text"
                value={menuLangPack}
                onChange={e => setMenuLangPack(e.target.value)}/>
            <br/>
            <label className="text-label">
                URL:
            </label>
            <input
                type='text'
                name='url'
                className="input-text"
                value={url}
                onChange={e => setUrl(e.target.value)}/>
            <br/>
            <button onClick={sendData}>
                sendData
            </button>
        </div>
    )
}


export default PopTemplate;