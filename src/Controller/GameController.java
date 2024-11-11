package Controller;

import models.Board;
import models.Game;
import models.Player;

import java.util.List;

public class GameController {

    Game game = new Game();
    public Game createGame(int dimension, List<Player> players){
        return new Game.Builder()
                .setDimension(100)
                .setPlayers(players)
                .build();
    }

    public void nextMove(Game game){
        game.nextMove();
    }
}
