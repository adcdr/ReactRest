package controller;

import model.Game;
import model.ServerState;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MoveController {

    @RequestMapping("/move")
    public Object process(@RequestParam Map<String,String> params) {
        Integer id = null;
        Integer from = null;
        Integer to = null;
        String error = null;

        try {
            id = Integer.valueOf(params.get("id"));
        } catch (NumberFormatException e) {
            error = "\nERROR: Param \"id\" is missing or has an unexpected value: " + id + ".";
        }

        try {
            from = Integer.valueOf(params.get("from"));
        } catch (NumberFormatException e) {
            error += "\nERROR: Param \"from\" is missing or has an unexpected value: " + from + ".";
        }

        try {
            to = Integer.valueOf(params.get("to"));
        } catch (NumberFormatException e) {
            error = "\nERROR: Param \"to\" is missing or has an unexpected value: " + to + ".";
        }

        if (error == null) {
            Game game = ServerState.games.get(id);
            game.makeMove(from, to);

            if (game != null)
                return game;
            else
                error = "ERROR: Game with ID, " + id + ", not found.";
        }

        return error;
    }
}
