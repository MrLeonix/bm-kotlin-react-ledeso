import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

ReactDOM.render(
    <React.StrictMode>
        <h1>Equation validator</h1>
        <p>Is <span className='equation'>1 + 2 = 3</span> valid?</p>
    </React.StrictMode>,
    document.getElementById('root')
);
