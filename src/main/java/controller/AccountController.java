package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AccountController {
    @RequestMapping("/account")
    public Object process(HttpSession session) {
        return "{\"username\": \"" + session.getAttribute("username") + "\"}";
    }
}