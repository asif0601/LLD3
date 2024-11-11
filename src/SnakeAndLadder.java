import Controller.GameController;
import models.Board;
import models.Game;
import models.GameState;
import models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadder {
    public static void main(String[] args) {
        System.out.println("Start the game: ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of players: ");
        int noOfPlayers = scanner.nextInt();

        System.out.println("Enter bot present or not: y/n");
        String isBot = scanner.next();
        List<Player> players = new ArrayList<>();

        if(isBot.equals("y")){
            System.out.println("Enter bot name: ");
            String name = scanner.next();

            System.out.println("Enter bot symbol: ");
            String symbol = scanner.next();
            players.add(new Player(name, symbol));
            noOfPlayers--;
        }
        for(int i=0;i<noOfPlayers;i++){
            System.out.println("Enter player name: ");
            String name = scanner.next();

            System.out.println("Enter player symbol: ");
            String symbol = scanner.next();
            players.add(new Player(name, symbol));
        }

        GameController gameController = new GameController();
        Game game = gameController.createGame(100,players );

        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.nextMove(game);

        }



    }
}
