import React, {Component} from 'react';

import './footer.css';

class Footer extends Component {
  render() {
    return (
      <div>
        <div className="marge"></div>
        <p className="footer">
          (c)2017 - Fred@Simplon
        </p>
        <div className="marge"></div>
      </div>
    )
  }
}

export default Footer;
