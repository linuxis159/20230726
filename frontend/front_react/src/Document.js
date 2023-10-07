import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";

function Document(){
    const {docTitle} = useParams();
    const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;
    const [resultDoc, setResultDoc] = useState('');
    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(`${serverUrl}/searchDoc?query=${docTitle}`);
            const data = await response.json();
            setResultDoc(data);
        };
        fetchData();
    }, [docTitle]);



    return (
        <div>
            {resultDoc.desc}
        </div>
    )
}


export default Document;