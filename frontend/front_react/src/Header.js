import React, {useEffect, useState} from 'react';
import './Header.css';

import {Form, ListGroup} from "react-bootstrap";
import {Link} from "react-router-dom";

const Header = () => {
    const [query, setQuery] = useState('');
    const [results, setResults] = useState([]);

    const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;
    const handlerSearch = async () => {
        const response = await fetch(`${serverUrl}/searchTitle?query=${query}`);
        const data = await response.json();
        setResults(data);
    }

    const handlerSearchDoc = async () => {
        const response = await fetch(`${serverUrl}/searchDoc?query=${query}`);
        const data = await response.json();
        setResults(data);
    }

    const handleClick = (text) => {
        setQuery(text);
    };
    useEffect(() => {
        if (query) { // query가 비어있지 않을 때만 검색을 실행합니다.
            handlerSearch();
        }
    }, [query]);
    return(

        <div className='header'>
{/*            <input type="text" value={query} onChange={e => {
                setQuery(e.target.value);
            }
            } />*/}
                <Form.Control
                    type="text"
                    value={query}
                    onChange={e => {
                        setQuery(e.target.value);
                    }}
                    placeholder="Start typing..."
                />
            <button type="submit">Search</button>
                {results.length > 0 && (
                    <ListGroup>
                        {results.map((item, index) => (
                            <Link to={`/searchDoc/${item}`} key={index}>
                                <ListGroup.Item>{item}</ListGroup.Item>
                            </Link>
                        ))}
                    </ListGroup>
                )}



        </div>
    )
}

export default Header;