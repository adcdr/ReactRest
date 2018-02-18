'use strict'

const React = require('react')
const $ = require('jquery')
const SockJS = require('sockjs-client')
const Stomp = require('@stomp/stompjs')
const ReactDOM = require('react-dom')
const client = require('./client')

var stompClient = null
var ws = null

class Lobby extends React.Component {
    constructor(props) {
        super(props)
        this.state = {players: [], user: ""}

        var ws = new WebSock()
        ws.connect()
    }

    componentDidMount() {
        client({method: 'GET', path: '/players'}).then(response => {
                this.setState({players: response.entity})
            })

        client({method: 'GET', path: '/account'}).then(response => {
                this.setState({user: response.entity})
            })
    }

    render() {
        return (
            <Players players={this.state.players} user={this.state.user}/>
        )
    }
}

class Players extends React.Component {
    constructor(props) {
        super(props);

        this.handleSend = this.handleSend.bind(this);
    }

    handleSend(event) {
        var userInput = $('#chat-input').val()
        var msg = "{\"name\": \"" + userInput + "\"}"
        console.log("<< " + msg)
        $('#chat-output').val(function(i, text){
                return text + "<< " + msg + "\n"
            })
        stompClient.send("/app/hello", {}, msg)
    }

    render() {
        if (this.props) {
            if (this.props.user.username && this.props.players) {
                return (
                    <div>
                        <div id="welcome">Welcome, {this.props.user.username}</div>
                        <fieldset>
                            <legend>Players</legend>
                            <table>
                                <tbody><Rows players={this.props.players} username={this.props.user.username}/></tbody>
                            </table>
                        </fieldset>
                        <fieldset>
                            <legend>Chat</legend>
                            <div>
                                <textarea id="chat-output" style={{width:'500px', height:'300px'}}></textarea>
                           </div>
                            <div>
                                <input type="text" id="chat-input"></input>
                                <button id="chat-send" onClick={this.handleSend}>Send</button>
                            </div>
                        </fieldset>
                    </div>
                )
            }
        }

        return (
            <div>loading...</div>
        )
    }
}

class Rows extends React.Component {
    constructor(props) {
        super(props);

        this.handleChallenge = this.handleChallenge.bind(this);
    }

    handleChallenge(event) {
        var userInput = $('#chat-input').val()
        var msg = "{\"from\": \"" + this.props.username + "\", \"to\": \"" + event.target.id + "\"}"
        console.log("<< " + msg)
        $('#chat-output').val(function(i, text){
                return text + "<< " + msg + "\n"
            })
        stompClient.send("/app/new-game", {}, msg)
    }

    render() {
        var rows = [];

        for (name in this.props.players) {
            if (name != this.props.username) {
                rows.push(
                    <tr key={name}>
                        <td key={name}>{name}</td>
                        <td><button id={name} onClick={this.handleChallenge}>Challenge</button></td>
                    </tr>
                )
            } else {
                rows.push(
                    <tr key={name}>
                        <td key={name}>{name}</td>
                        <td></td>
                    </tr>
                )
            }
        }

        return rows
     }
}

class WebSock {
    connect() {
        var socket = new SockJS('/ws')
        stompClient = Stomp.over(socket)
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame)
            stompClient.subscribe('/lobby/greetings', function (greeting) {
                console.log(">> " + JSON.parse(greeting.body).content)
                $('#chat-output').val(function(i, text){
                    return text + ">> " + JSON.parse(greeting.body).content + "\n"
                  })
            })
            stompClient.subscribe('/lobby/inc-game', function (message) {
                    console.log(">> " + message.body)
                    $('#chat-output').val(function(i, text){
                        return text + ">> " +message.body + "\n"
                      })
                })
        })
    }

    disconnect() {
        if (stompClient !== null) {
            stompClient.disconnect()
        }
        setConnected(false);
        console.log("Disconnected")
    }
}

ReactDOM.render(
    <Lobby />,
    document.getElementById('lobby')
)