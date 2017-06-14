import React, { Component } from 'react';
import { Router, Route, Redirect } from 'react-router';
import createBrowserHistory from 'history/createBrowserHistory';

const history = createBrowserHistory();

import About from './About/About.js';// /about
import Header from './Header/Header.js';// /
import Home from './Home/Home.js';// /home et /
import Nav from './Nav/Nav.js';// Tous les /*

class RouterComponent extends Component {

  componentWillMount () {
    // $.post('www.site.com/api/authenticate', function (data) {
    //   if (data) userConnected = true;
    // });
    this.setState({userConnected: true});
  }

  render() {
    return (
      <Router history={history}>
          <div>
            <Route exact path="/" component={Header} />
            <Route path="/" component={Nav} />
            <Route exact path="/home" component={Home} />
            {/* <Route exact path="/" component={Home} /> */}
            <Route exect path="/about" component={About} />

            {this.state.userConnected ? (<Redirect to="/home" />) : (<Redirect to="/" />)}
          </div>
        </Router>
    );
  }
}

export default RouterComponent;
