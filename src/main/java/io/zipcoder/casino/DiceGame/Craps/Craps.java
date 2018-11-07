package io.zipcoder.casino.DiceGame.Craps;

import io.zipcoder.casino.CardGame.Solitaire.Tableau;
import io.zipcoder.casino.DiceGame.Dice;
import io.zipcoder.casino.DiceGame.DiceGame;
import io.zipcoder.casino.Interfaces.Gamble;
import io.zipcoder.casino.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class Craps extends DiceGame implements Gamble {


    public int[] betOptions = {2, 3, 4, 5, 6, 8, 9, 10, 11, 12};
    int rollNumber = 0;
    private ArrayList<CrapsPlayers> crapsPlayers;
    private int minBet;
    private Player player;
    private Map<Integer, Integer> betPots;
    private Dice dice;
    private int pointer;

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }


    public Craps(Player player) {
        CrapsPlayers crappyPlayer = new CrapsPlayers(player);
        ArrayList<Integer> betOptions = new ArrayList<>(10);
        this.crapsPlayers = new ArrayList<>();
        this.minBet = 10;
        this.dice = new Dice();
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
            //player wins!!
        } else if (rollDice() == 2 || rollDice() == 3 || rollDice() == 12) {
            //player loses :(
        } else {
            pointer = rollDice();
        }
    }

    public void remainingRolls() {
        rollDice();
        if (rollDice() == pointer) {
            //player wins pot
        } else if (rollDice() == 7) {
            //player loses all money in pot
        } else {
            //if betOptions == rollDice()
            //casino adds money to the pot - matching whatever bet the player made
        }
    }

    public int betAmount(int amount, Player player) {
        return amount;
    }

    public void bet() {


    }

    public void distributePot(int amount, Player player) {

    }

    public void start() {
        //when starting a game passLine bet or dontPassLine bet is made


    }

    public void end() {

    }

    public void takeATurn() {

    }

    public void addPlayer(Player player) {
        CrapsPlayers crappyPlayer = new CrapsPlayers(player);
        this.crapsPlayers.add(crappyPlayer);
    }

    public void removePlayer(Player player) {
        for (CrapsPlayers crappyPlayer : crapsPlayers) {
            if (crappyPlayer.getPlayer() == player) {
                this.crapsPlayers.remove(crappyPlayer);
                break;
            }

        }

    }
}