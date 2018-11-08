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
        System.out.println("What would you like to bet? Min bet is: $" + minBet);
        int amount = scanner.nextInt();
        if (amount<minBet){
            System.out.println("Sorry but the minimum bet is $"+minBet);
            gamePlay();
        }
        crapsPlayer.setInitialBet(amount);
        System.out.println("Are you ready to roll?  yes or no");
        String response = scanner.next();
        if(response.equalsIgnoreCase("yes")) {
        } else if(response.equalsIgnoreCase("no")) {
            gamePlay();
        } else{
            System.out.println("no valid");
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
        int result = rollDice();
        if (result == 7 || result == 11) {
            win(crapsPlayer);
        } else if (result == 2 || result == 3 || result == 12) {
            lose(crapsPlayer);
        } else {
            pointer = result;
        }
    }

    public void remainingRolls() {
        int result = rollDice();
        if (result == pointer) {
            win(crapsPlayer);
        } else if (result == 7) {
            lose(crapsPlayer);
        } else remainingRolls();
    }

    public int betAmount(int amount, Player player) {
        return amount;
    }

    public int betAmount(int amount, CrapsPlayers crapsPlayers) {
        crapsPlayers.addToBetPot(amount);
        return betAmount(amount, crapsPlayers.getPlayer());
    }

    public void win(CrapsPlayers crapsPlayers){
       crapsPlayers.setWallet(crapsPlayers.getWallet() + crapsPlayers.getInitialBet() * 2);
        System.out.println("Congrats! You won: $" + crapsPlayers.getInitialBet());
        playAgain();
    }

    public void lose(CrapsPlayers crapsPlayers) {
        System.out.println("I'm so sorry, you lose!");
      playAgain();
    }

    public void playAgain(){
        System.out.println("Would you like to play again?");
        String response = scanner.next();
        if(response.equalsIgnoreCase("yes")) {
            start();
        } else if(response.equalsIgnoreCase("no")) {
            end();
        } else {
            System.out.println("Sorry I didn't quite get that, try again!");
        }
        end();
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