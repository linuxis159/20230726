import React, {useState} from 'react';
import {Button, Form, Tab, Tabs} from "react-bootstrap";
import ReactQuill from "react-quill";
import 'react-quill/dist/quill.snow.css';
import './WriteDocument.css';

const WriteDoucment = () => {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');

    const handleSubmit = () => {
        // 서버에 데이터를 전송하는 로직
        // 예: axios.post('/api/posts', { title, content });
        console.log('제목:', title);
        console.log('내용:', content);
    };

    return (
        <div className="writeDocument">
            <input className = "titleForm"
                type="text"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                placeholder="제목을 입력하세요."
            />
            <ReactQuill className = "descriptionForm" value={content} onChange={setContent} />
            <br/>
            <br/>
            <br/>

            <button onClick={handleSubmit}>제출</button>
        </div>
    );
}


export default WriteDoucment;