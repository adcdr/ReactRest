package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LobbyController {

    @RequestMapping("/lobby")
    public Object process() {
        return "lobby";
    }
}
