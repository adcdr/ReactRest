package controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NewGameWSController {
    @MessageMapping("/new-game")
    @SendTo("/lobby/inc-game")
    public String newGame(NewGameMessage message) throws Exception {
        return "{\"newgame\" : \"" + message.getFrom() + "\"}";
    }
}