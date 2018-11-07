package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame.Craps.Craps;
import io.zipcoder.casino.DiceGame.DiceGame;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    Player Crappy = new Player("Crappy");
    Craps game1 = new Craps(Crappy);

    @Test
    public void rollDiceTest(){
        int actual = game1.rollDice();
        Assert.assertTrue((2 < actual) && (actual < 12));
    }

}
