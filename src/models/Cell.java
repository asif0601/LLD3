package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cell {
    private int number;
    private List<Player> currPlayer;

    public Cell(int number){
        this.number = number;
        currPlayer = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public List<Player> getPlayer() {
        return currPlayer;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPlayer(List<Player> player) {
        this.currPlayer = player;
    }
}
