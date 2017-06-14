import React, { Component } from 'react';

class Cart extends Component {

	render () {
		return (
			<div className="cart">
				CART
				<div>Total : {this.props.click}</div>
				<ul>
				  this.props.cart.map(
						(product,i) => <li key={i}> {product.name} : {product.price} </li>
					)
				</ul>
			</div>
		)
	}
}

export default Cart;
