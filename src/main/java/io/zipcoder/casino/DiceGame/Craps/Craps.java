package io.zipcoder.casino.DiceGame.Craps;

import io.zipcoder.casino.DiceGame.DiceGame;
import io.zipcoder.casino.Interfaces.Gamble;
import io.zipcoder.casino.Player;

import java.util.Map;

public class Craps extends DiceGame implements Gamble {

    private Player player;
    private int hold;
    private Map<Integer, Integer> betPots;

    public Craps(Player player) {
        this.player = player;
    }

    public int rollDice() {
        return 0;
    }

    public int betAmount(int amount, Player player) {
        return 0;
    }

    public void distributePot(int amount, Player player) {

    }

    public void start() {

    }

    public void end() {

    }

    public void takeATurn() {

    }

    public void addPlayer(Player player) {

    }

    public void removePlayer(Player player) {

    }
}
