import React, {useState} from 'react';
import {Button, Form, Tab, Tabs} from "react-bootstrap";
import ReactQuill from "react-quill";
import 'react-quill/dist/quill.snow.css';
import './WriteDocument.css';

const WriteDoucment = () => {
    const [title, setTitle] = useState('');
    const [desc, setDesc] = useState('');
    const [results, setResults] = useState('')

    const handleSubmit = async () => {
        const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;
        const data = {
            title,
            desc
        }
        const response = await fetch(`${serverUrl}/writeDocument`, {
            method : 'POST',
            headers : {
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify(data)
        });
        const serverResponse = await response.json();
        setResults(serverResponse);
    };

    return (
        <div className="writeDocument">
            <input className = "titleForm"
                type="text"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                placeholder="제목을 입력하세요."
            />
            <ReactQuill className = "descriptionForm" value={desc} onChange={setDesc} />
            <br/>
            <br/>
            <br/>

            <button onClick={handleSubmit}>제출</button>
        </div>
    );
}


export default WriteDoucment;