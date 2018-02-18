package controller;

import model.ServerState;
import model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@RestController
public class RegisterController {

    @RequestMapping("/register")
    public Object process(@RequestParam Map<String,String> params, HttpServletResponse response, HttpSession session) throws IOException {
        String name = params.get("name");
        String error = null;

        if (name == null || name.isEmpty())
            error = "ERROR: Param \"name\" is missing or has an unexpected value: "  + name + ".";

        if (error == null) {
            User user = ServerState.users.get(name);

            if (user != null) {
                error = "ERROR: User with name: " + name + ", already exists.";
            } else {
                session.setAttribute("username", name);
                ServerState.users.put(name, new User(name));
                response.sendRedirect("/lobby");
            }
        }

        return error;
    }
}
