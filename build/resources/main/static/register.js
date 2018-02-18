'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class RegisterForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {value: ''};

    this.handleChange = this.handleChange.bind(this)
    this.handleSubmit = this.handleSubmit.bind(this)
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    client({method: 'GET', path: '/register?name=' + this.state.value}).then(response => {
            window.location.href = '/lobby'
        });

    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Name:
          <input type="text" value={this.state.value} onChange={this.handleChange} />
        </label>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}

ReactDOM.render(
    <RegisterForm />,
    document.getElementById('register')
)