import React from 'react';
import MenuItem from "./MenuItem.js";

function Menu() {
    return (
        <nav className="photo-main-menu">
            <ul>
                <MenuItem menuName="Home"/>
                <MenuItem menuName="About"/>
                <MenuItem menuName="Services"/>
                <MenuItem menuName="Gallery"/>
                <MenuItem menuName="Blog"/>
                <MenuItem menuName="Contact"/>
            </ul>
        </nav>
    );
}

export default Menu