import React, { Component } from 'react';
// import logo from './logo.svg';
import './App.css';

import MaBalise from './Test/Test.js';

import Shop from './Shop/Shop.js';
import Cart from './Shop/Cart/Cart.js';
import Product from './Shop/Product/Product.js';

class App extends Component {
  render() {
    return (
      <div className="product">

        {/*
        <Cart className="invisible"/>
        <Product className="invisible"/>
        */}
        
        <MaBalise className="titre" quoi="React    " comment="plutôt" />
        <br />


      {/*
        <MaBalise quoi="La pomme " comment="à priori" />
        <MaBalise quoi="Java     " comment="très" />
        <MaBalise quoi="La Poste " comment="à mon avis mais ça n'engage que moi, très" />
        <MaBalise quoi="Simplon  " comment="super" />
        */}

        <br/>

        <Shop />

      </div>
    );
  }
}

export default App;
