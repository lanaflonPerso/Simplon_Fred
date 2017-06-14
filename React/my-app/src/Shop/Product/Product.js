import React, { Component } from 'react';

class Product extends Component {

	// transferAdd = () => {
	// 	this.props.add(this.props.name, this.props.price);
	// }

	transferAdd = () => {
		this.props.add(this.props.name, this.props.price);
//		this.props.product(this.props.name);
	}

	render () {
		return (
			<div className="product">
				{this.props.name} : {this.props.price * 1.2} € <br/>
				<button type="button" className="button" onClick={this.transferAdd}>Ajouter au panier</button>
			</div>
		)
	}
}

export default Product;
