package controller;

import model.Game;
import model.ServerState;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetGameController {

    @RequestMapping("/getgame")
    public Object process(@RequestParam Map<String,String> params) {
        String gameId = params.get("id");
        String error = null;

        if (gameId == null || gameId.isEmpty())
            error = "ERROR: Param \"id\" is missing or has an unexpected value: "  + gameId + ".";

        if (error == null) {
            Game game = ServerState.games.get(Integer.parseInt(gameId));

            if (game != null) {
                return game;
            } else {
                error = "ERROR: Game with ID: " + gameId + ", was not found.";
            }
        }

        return error;
    }
}
