import React, {useEffect, useState} from 'react';
import './Header.css';


const Header = () => {
    const [query, setQuery] = useState('');
    const [results, setResults] = useState([]);

    const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;
    const handlerSearch = async () => {
        const response = await fetch(`${serverUrl}/query?query=${query}`);
        const data = await response.json();
        setResults(data);
    }
    useEffect(() => {
        if (query) { // query가 비어있지 않을 때만 검색을 실행합니다.
            handlerSearch();
        }
    }, [query]);
    return(
        <div className='header'>
            <input type="text" value={query} onChange={e => {
                setQuery(e.target.value);
            }
            } />
            <button type="submit">Search</button>
            {results.length > 0 && (
                <ul>
                    {results.map((result, index) => (
                        <li key={index}>{result}</li>
                    ))}
                </ul>
            )}
        </div>
    )
}

export default Header;