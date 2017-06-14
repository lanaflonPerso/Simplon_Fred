import React from 'react';
import {Link} from 'react-router-dom';

const Nav = () => (
  <div>
    NAV : Ceci est la barre de navigation de mon site.
    <Link to="/about">Go to about</Link> 
  </div>
);

export default Nav;
