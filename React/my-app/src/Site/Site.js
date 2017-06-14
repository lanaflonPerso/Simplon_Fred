import React, {Component} from 'react';
import 'semantic-ui-css/semantic.min.css';
import {Router, Route} from 'react-router';
import createBrowserHistory from 'history/createBrowserHistory';

import axios from 'axios';

const history = createBrowserHistory();

import Items from './Items/Items.js';
import Head from './Head/Head.js';
import Nav from './Nav/Nav.js';
import About from './About/About.js';
import Help from './Help/Help.js';
import Footer from './Footer/Footer.js';
import User from './User/User.js';

class Site extends Component {

  // componentDidMount() {
  //   axios.get('/utilisateurs')
  //   .then (function (data) {
  //     console.log('-----------------------------------');
  //     console.log(data);
  //     console.log('-----------------------------------');
  //   })
  //   .catch(function (err) {
  //     console.log('-----------------------------------');
  //     console.log(err);
  //     console.log('-----------------------------------');
  //   });
  // }

  render() {
    return (
      <Router history={history}>
        <div>
          <Route path="/"        component={Head} />
          <Route path="/"        component={Nav} />
          <Route path="/home"    component={About} />
          <Route path="/gallery" component={Items} />
          <Route path="/help"    component={Help} />
          <Route path="/"        component={Footer} />
          <Route path="/user"    component={User} />
        </div>
        {/* <Head/><Nav /><Items /> */}
      </Router>
    )
  }
}

export default Site;
