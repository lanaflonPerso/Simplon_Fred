import React, {Component} from 'react';
import {Image, Segment, Header, Divider} from 'semantic-ui-react';

import landscape from './head.jpg';

class Head extends Component {
  render() {
    return (
      <div>
        <Image src={landscape} />
        <Segment basic>
          <Header as="h2" color="grey">Mon blog de voyage</Header>
        </Segment>
        <Divider section/>
      </div>
    )
  }
}

export default Head;
