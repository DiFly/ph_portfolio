import React from 'react';
import Menu from './Menu.js';
import Footer from './Footer.js';

const SideBar = ({ name }) => {
    return (
        <aside className="photo-aside">
            <div className="photo-logo">
                <a href="#"><img src="" alt="logo"/></a>
                <h1>{ name }</h1>
                <p>photographer</p>
            </div>
            <Menu/>
            <Footer/>
        </aside>
    );
}

export default SideBar