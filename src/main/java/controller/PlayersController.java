package controller;

import model.ServerState;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class PlayersController {

    @RequestMapping("/players")
    public Object process(HttpSession session) {
        return ServerState.users;
    }
}