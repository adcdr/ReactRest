package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class RootController {

    @RequestMapping(value = "/")
    public String index(HttpSession session) throws IOException {
        String username = (String) session.getAttribute("username");

        if (username == null) {
            return "register";
        }

        return "lobby";
    }
}