import React, { Component } from 'react';

import RouterComponent from './Router/Router.js';
import Site from './Site/Site.js';

import logo from './logo.svg';
import './App.css';

class App extends Component {

  render() {
    return (
      <div>
        <Site />
      </div>
    );
  }
}

export default App;
