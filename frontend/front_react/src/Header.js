import React from 'react';
import './Header.css';

const Header = () => {
    const [query, setQuery] = useState('');
    const [results, setResults] = useState([]);

    const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;
    const handlerSearch = async () => {
        const response = await fetch(`${serverUrl}/search?query=${query}`);
        const data = await response.json();
        setResults(data);
    }
    return(
        <div className='header'>
            <input type="text" value={query} onChange={e => {
                setQuery(e.target.value);
                handleSearch();

            }
            } />
            <ul>

            </ul>
            <button type="submit">Search</button>
        </div>
    )
}

export default Header;