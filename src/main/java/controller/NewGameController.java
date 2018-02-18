package controller;

import model.Game;
import model.ServerState;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NewGameController {

    @RequestMapping("/newGame")
    public Object process(@RequestParam Map<String,String> params) {
        String wPlayer = params.get("white");
        String bPlayer = params.get("black");
        String error = null;

        if (wPlayer == null || wPlayer.isEmpty())
            error = "ERROR: Param \"white\" is missing or has an unexpected value: " + wPlayer + ".";

        if (bPlayer == null || bPlayer.isEmpty())
            error += "\nERROR: Param \"black\", is missing or has an unexpected value: " + bPlayer + ".";

        if (error == null) {
            int gameId = ServerState.currentGamedId.incrementAndGet();
            Game game = new Game(gameId, wPlayer, bPlayer);
            ServerState.games.put(gameId, game);

            return game;
        }

        return error;
    }
}
