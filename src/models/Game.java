package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Integer size;
    private Integer currPlayerIndex;
    private List<Move> moves;
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private List<Integer> allPlayerIndex;

    public Integer getSize() {
        return size;
    }

    public Integer getCurrPlayerIndex() {
        return currPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<Integer> getAllPlayerIndex() {
        return allPlayerIndex;
    }

    public Game(){}
    public Game(Builder builder){
        this.size = 10;
        this.currPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        gameState = GameState.IN_PROGRESS;
        allPlayerIndex = new ArrayList<>();
        for(int i=0;i<players.size();i++){
            allPlayerIndex.add(1);
        }
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;
        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }
        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }
        public Game build(){
            return new Game(this);
        }
    }
    public void nextMove(){
        Player currPlayer = players.get(currPlayerIndex);
        System.out.println("player move : " + currPlayer.getName());
        System.out.println("Player symbol: "+ currPlayer.getSymbol());
        System.out.println("Curr board:  ");
        board.printCurrBoard();
        int num = currPlayer.takeNextMove();
        Integer currCellNumber = allPlayerIndex.get(currPlayerIndex);
        if(currCellNumber + num == 100) {
            System.out.println("Winner of the game : " +currPlayer.getName());
            gameState = GameState.ENDED;
        } else if(currCellNumber + num < 100) {
            allPlayerIndex.set(currPlayerIndex, currCellNumber + num);
            List<Player> currIndexPlayer = board.getBorad().get(currPlayerIndex).getPlayer();
            for(int i=0;i<currIndexPlayer.size();i++){
                System.out.println("remove Player");
                if(currPlayer.getSymbol().equals(currIndexPlayer.get(i).getSymbol())){
                    System.out.println("removed");
                    currIndexPlayer.remove(i);
                    board.getBorad().get(currPlayerIndex).setPlayer(currIndexPlayer);
                    break;
                }
            }
            List<Player> nextIndexPlayer = board.getBorad().get(currCellNumber + num).getPlayer();
            nextIndexPlayer.add(currPlayer);
            board.getBorad().get(currCellNumber + num).setPlayer(nextIndexPlayer);
        }

        currPlayerIndex = (currPlayerIndex+1)%players.size();

    }


}
