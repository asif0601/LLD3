package models;

public class Bot extends Player{
    public Bot(String name, String symbol){
        super(name, symbol);
    }
    public int takeNextMove(){
        return (int)(Math.random() *7);
    }
}
