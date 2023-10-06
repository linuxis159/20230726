import React, {useEffect} from 'react';
import {useParams} from "react-router-dom";

function Document(){
    const {docTitle} = useParams();
    const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;
    useEffect(() => {
        return async () => {
            const response = await fetch(`${serverUrl}/searchDoc?query=${docTitle}`);
            const data = await response.json();
        };
    }, [docTitle]);
    return (
        <div>
            {docTitle}
        </div>
    )
}


export default Document;