import React, {useState} from 'react';
import './Header.css';

const Header = () => {
    const [query, setQuery] = useState('');
    const [results, setResults] = useState([]);
    const serverUrl = process.env.REACT_APP_LOCAL_SERVER_URL;
    const handleInputChange = async (e) => {
        const value = e.target.value;
        setQuery(value);
        if(value){
            try{
                const response = await fetch(`${serverUrl}/searcg?query=${value}`);
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const data = await response.json();
                setResults(data);

            }catch (error) {
                console.error("Error fetching data", error);
            }
        }
        else {
           // setResults([]);
        }
    }
    return (
        <div className="header">
            <input
                type="text"
                value={query}
                onChange={handleInputChange}
                placeholder="Search..."
            />
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