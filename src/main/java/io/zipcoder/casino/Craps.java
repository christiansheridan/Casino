package io.zipcoder.casino;

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

}
