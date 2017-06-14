import React, { Component } from 'react'
import { Button, Dropdown, Menu } from 'semantic-ui-react'
import {Link} from 'react-router-dom';

export default class Nav extends Component {
  state = { activeItem: 'home' }

  handleItemClick = (e, { name }) => this.setState({ activeItem: name })

  render() {
    const { activeItem } = this.state

    return (
      <Menu size='large'>

            <Menu.Item as={Link}  to="/home"     name='home'     active={activeItem === 'home'}   onClick={this.handleItemClick} />
            <Menu.Item as={Link}  to="/gallery"  name='Gallery'  active={activeItem === 'gallery'}  onClick={this.handleItemClick} />
            <Menu.Item as={Link}  to="/help"     name='Help'     active={activeItem === 'help'}   onClick={this.handleItemClick} />
            <Menu.Item as={Link}  to="/user"     name='User'     active={activeItem === 'user'}   onClick={this.handleItemClick} />

        <Menu.Menu position='right'>
          <Dropdown item text='Language'>
            <Dropdown.Menu>
              <Dropdown.Item>English</Dropdown.Item>
              <Dropdown.Item>French</Dropdown.Item>
              <Dropdown.Item>Spanish</Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>

          <Menu.Item>
            <Button primary>Sign Up</Button>
          </Menu.Item>
        </Menu.Menu>
      </Menu>
    )
  }
}
