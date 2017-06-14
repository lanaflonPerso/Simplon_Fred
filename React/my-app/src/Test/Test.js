import React, { Component } from 'react';

// const myVar = 'Mon texte ! ';

class Test extends Component {
  // Une des methodes du lifecycle des Component de React qui s'appelle Render
  // Permet de display notre HTML.

  constructor (props) {
    super(props);
    this.state = {
      greeting: 'bien',
      increment: 0,
      date: new Date()
    };
  }


componentDidMount() {
  this.timer = setInterval(this.tick, 1000)
}

  tick = () => {
    let newTime = this.state.increment+1;

    this.setState({
      increment: newTime,
      date: new Date()
    });
}


  render () {

    return (
      <div className="Test">
        <br />
        <br />
        {this.props.quoi} est {this.props.comment} {this.state.greeting} ! Compteur : {this.state.increment} - Date/heure : {this.state.date.toLocaleTimeString()}
      </div>
     )
  }
}

export default Test;
