import React, { Component } from 'react';
import Cart from './Cart/Cart.js'
import Product from './Product/Product.js'
import products from './products.json'
import './shop.css';

class Shop extends Component {

	constructor (props) {
		super(props);
		this.state = {
			cart: [],
			product: [],
			click: 0
		};

		// Dans le constructeur et identique à changeChild plus bas
		// this.changeChild = this.changeChild.bind(this);
	}

	componentWillMount() {
		// Là où se ferait les appels à l'API
		this.setState({
			products: products.datas
		});
	}

	incrementClick = () => {
		let newClick = this.state.click;
		newClick++;
		this.setState({click: newClick});
	}

	addToCart = (productName, productPrice) => {
		let newCart = this.state.cart;
		newCart.push({
			name: productName,
			price: productPrice
		});
		this.setState({cart: newCart});
		// console.log('Je peux communiquer avec le parent');
	}

	// J'ajoute des produits à mon panier
	// addToCart = (productPrice) => {
	// 	let newCart = this.state.cart;
  //   newCart.push(productPrice);
  //   this.setState({cart:newCart});
  // }

  consoleProductName = (productName) => {
		// Cette fonction doit console.log le nom d'un produit
    // Il faudra l'ajouter en props à chaque <Product console={this.consoleProductName}/>
    // Dans le component Product on va créer une fonction pour relayer le nom du produit
    // Cette fonction va appeler this.props.console avec le bon argument (this.props.name)
		let newProduct = this.state.product;
		newProduct.push(productName);
		this.setState({product: newProduct});
  }

 componentDidUpdate() {
	 console.log(this.state.cart);
	 console.log(this.state.product);
	}

	render () {
		return (
			<div className="shop">
			<Cart click={this.state.click} cart={this.state.cart}/>
				{
					this.state.products.map(
						(product, i)  => <Product key={i}  price={product.price} name={product.name} add={this.addToCart} product={this.consoleProductName} increment={this.incrementClick}/>
					)
				}

			</div>
		)
	}
}

export default Shop;
