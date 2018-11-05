package io.zipcoder.casino;

public abstract class DiceGame implements Game {

    private int numOfDice = 2;
    private int[] die = new int[numOfDice];

    public int rollDice(int numOfDice) {
        int sum = 0;

        for (int i = 0; i < numOfDice; i++) {
            die[i] = (int) Math.floor((Math.random() * 6) + 1);
            sum += die[i];
        }

        return sum;
    }

}
