import React, {useEffect, useState} from 'react';
import './Header.css';

import {Form, ListGroup} from "react-bootstrap";
import {Link} from "react-router-dom";

const Header = () => {
    const [query, setQuery] = useState('');
    const [results, setResults] = useState([]);

    const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;

    useEffect(() => {
        return async () => {
            if(query == null || query == '') {
                initTitleDrop()
            }
        };
    }, [query]);
    const handlerSearch = async (data) => {
        if(data == null || data == '') {
            return;
        }
        const response = await fetch(`${serverUrl}/searchTitle?query=${data}`);
        const serverResponse = await response.json();
        setResults(serverResponse);
    }

    const handlerSearchDoc = async () => {
        const response = await fetch(`${serverUrl}/searchDoc?query=${query}`);
        const data = await response.json();
        setResults(data);

    }
    const initTitleDrop = () => {
        setResults('')
    }


    return(

        <div className='header'>
{/*            <input type="text" value={query} onChange={e => {
                setQuery(e.target.value);
            }
            } />*/}
                <Form.Control
                    type="text"
                    onChange={e => {
                        if(e.target.value == '' || e.target.value == null){
                            setResults('')
                        }
                        setQuery(e.target.value);
                        handlerSearch(e.target.value)
                    }}

                    placeholder="Start typing..."
                />
            <button type="submit">Search</button>
                {results.length > 0 && (
                    <ListGroup>
                        {results.map((item, index) => (
                            <Link to={`/searchDoc/${item}`} key={index} onClick={initTitleDrop}>
                                <ListGroup.Item>{item}</ListGroup.Item>
                            </Link>
                        ))}
                    </ListGroup>
                )}



        </div>
    )
}

export default Header;