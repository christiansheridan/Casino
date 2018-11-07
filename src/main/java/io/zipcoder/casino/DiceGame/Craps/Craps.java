package io.zipcoder.casino.DiceGame.Craps;

import io.zipcoder.casino.CardGame.Solitaire.Tableau;
import io.zipcoder.casino.DiceGame.Dice;
import io.zipcoder.casino.DiceGame.DiceGame;
import io.zipcoder.casino.Interfaces.Gamble;
import io.zipcoder.casino.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Craps extends DiceGame implements Gamble {
    Scanner scanner;


    int rollNumber = 0;
    private CrapsPlayers crapsPlayer;
    private int minBet;
    private Player player;
    private Dice dice;
    private int pointer;


    public Craps(Player player) {
        CrapsPlayers crappyPlayer = new CrapsPlayers(player);
        this.crapsPlayer = new CrapsPlayers(player);
        this.minBet = 10;
        this.dice = new Dice();
        scanner = new Scanner(System.in);
    }

    public void gamePlay(){
        System.out.println("What would you like to bet? Min bet is: " + minBet);
        int amount = scanner.nextInt();
        System.out.println("Are you ready to roll?");
        String response = scanner.next();
        if(response.equalsIgnoreCase("yes")) {
            rollDice();
        } else {
            System.out.println("ready yet?");
        }
        firstRoll();
        remainingRolls();
    }

    public int rollDice() {
        int sum = rollDice(2);
        System.out.println("Total = " + sum);
        rollNumber++;
        return sum;
    }

    public void firstRoll() {
        rollDice();
        if (rollDice() == 7 || rollDice() == 11) {
            win(crapsPlayer);
        } else if (rollDice() == 2 || rollDice() == 3 || rollDice() == 12) {
            lose(crapsPlayer);
        } else {
            pointer = rollDice();
        }
    }

    public void remainingRolls() {
        rollDice();
        if (rollDice() == pointer) {
            win(crapsPlayer);
        } else if (rollDice() == 7) {
            lose(crapsPlayer);
        }
    }

    public int betAmount(int amount, Player player) {
        return amount;
    }

    public int betAmount(int amount, CrapsPlayers crapsPlayers) {
        crapsPlayers.addToBetPot(amount);
        return betAmount(amount, crapsPlayers.getPlayer());
    }

    public void win(CrapsPlayers crapsPlayers){
        player.setWallet(player.getWallet() + crapsPlayers.getBetPot() * 2);
        System.out.println("Congrats! You won: $" + crapsPlayers.getBetPot());
        System.out.println("Would you like to play again?");
        String response = scanner.next();
        if(response.equalsIgnoreCase("yes")) {
            start();
        } else if(response.equalsIgnoreCase("no")) {
            end();
        } else {
            System.out.println("Sorry I didn't quite get that, try again!");
        }
    }

    public void lose(CrapsPlayers crapsPlayers) {
        System.out.println("I'm so sorry, you lose!");
        System.out.println("Would you like to play again?");
        String response = scanner.next();
        if(response.equalsIgnoreCase("yes")) {
            start();
        } else if(response.equalsIgnoreCase("no")) {
            end();
        } else {
            System.out.println("Sorry I didn't quite get that, try again!");
        }
    }

    public void distributePot(int amount, Player player) {

    }

    public void start() {
        gamePlay();
    }

    public void end() {
        System.out.println("Would you like to leave the table?");
        String response = scanner.next();
        if(response.equalsIgnoreCase("yes")) {
            exitTable(crapsPlayer);
        } else if(response.equalsIgnoreCase("no")) {
            start();
        }

    }

    public void exitTable(CrapsPlayers crapsPlayer){
        removePlayer(player);
    }

    public void takeATurn() {

    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public void addPlayer(Player player) {
        CrapsPlayers crappyPlayer = new CrapsPlayers(player);
        this.crapsPlayer = crappyPlayer;
    }

    public void removePlayer(Player player) {
            if (crapsPlayer.getPlayer() == player) {
                this.crapsPlayer = null;
            }

        }

    }