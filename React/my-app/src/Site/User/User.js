import React, {Component} from 'react';
import {Card} from 'semantic-ui-react';
import axios from 'axios'; // Pour le BDD

class User extends Component{

  componentWillMount() {
    this.state = {users:[]};
    const componentInstance = this;

    axios.get('http://localhost:8080/utilisateurs')
    // axios.get('/utilisateurs')

    .then( (response) => {
        componentInstance.setState({users: response.data});
      })
    .catch((err) => {
      console.log('Failed to get user :::', err);
    });
  }

  render () {
    return (
      <div>
        {
          this.state.users.map(
          user =>
          <Card key={user.id}
             image=""
             header={user.username}
             description={user.roles[0]}
          />
        )
        }
      </div>
    )

  }
}

export default User;
