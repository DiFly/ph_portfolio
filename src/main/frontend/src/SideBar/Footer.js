import React from 'react';
import Social from "./Social.js";

function Footer() {
    return (
        <div className="photo-footer">
            <ul>
                <Social/>
                <Social/>
                <Social/>
                <Social/>
            </ul>
            <p><small>© 2020 Photo by MyThemes</small></p>
        </div>
    );
}
export default Footer