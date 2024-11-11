package models;

import Strategy.IRoleDice;
import Strategy.RoleDiceByRandom;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private String symbol;
    private IRoleDice iRoleDice;

    public Player(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
        iRoleDice = new RoleDiceByRandom();
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int takeNextMove(){

        System.out.println("Enter click y to execute the dice: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if(str.equals("y")){
            Random random = new Random();
            int num = random.nextInt(6) + 1;
            System.out.println("Get random number b/w 1-6 is: "+ num);
            return num;
        }
        return 0;
    }
}
