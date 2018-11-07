package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame.Craps.Craps;

public class Test {

    public static void main(String[] args) {

        Player Crappy = new Player("Crappy");
        Craps game1 = new Craps(Crappy);

        game1.gamePlay();
    }
}
