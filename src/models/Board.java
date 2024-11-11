package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    List<Cell> borad;

    public Board(int dimension){
        this.dimension = dimension;
        borad = new ArrayList<>();
        for(int i=0;i<=dimension;i++){
            borad.add(new Cell(i));
        }
    }

    public int getDimension() {
        return dimension;
    }

    public List<Cell> getBorad() {
        return borad;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setBorad(List<Cell> borad) {
        this.borad = borad;
    }

    public void printCurrBoard(){
        for(int i=0;i<dimension;i++){
            Cell cell = borad.get(i);
            List<Player> players = cell.getPlayer();
            System.out.print("|");
            for(int k=0;k<players.size();k++){
                System.out.print(players.get(k).getSymbol()+" ");
            }
            System.out.print("|");
            if((i+1)%10 == 0){
                System.out.println("");
            }
        }
    }
}
