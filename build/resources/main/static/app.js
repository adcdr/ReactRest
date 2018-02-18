'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {game: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/game?id=1'}).then(response => {
            this.setState({game: response.entity});
        });
    }

    render() {
        return (
            <Game game={this.state.game}/>
        )
    }
}

class Game extends React.Component {
    render() {
        var board = this.props.game.board;

        if (this.props && this.props.game && this.props.game.board && this.props.game.board.cells) {
            return (
                <table>
                    <tbody><Rows cells={this.props.game.board.cells}/></tbody>
                </table>
            )
        } else {
            return (
                <div>loading...</div>
            )
        }
    }
}

class Rows extends React.Component {
    render() {
        var rows = this.props.cells.map(function (row, i){
            var entry = row.map(function (element, j) {
                if (element) {
                    return (
                            <td key={j}>{element.name}</td>
                        )
                } else {
                    return (
                            <td key={j}></td>
                        )
                }
            })

            return (
                <tr key={i}>{entry}</tr>
             )
        })

        return rows
     }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)