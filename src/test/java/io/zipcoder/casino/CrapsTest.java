package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame.Craps.Craps;
import io.zipcoder.casino.DiceGame.Craps.CrapsPlayers;
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

    @Test
    public void testGamePlay(){
        game1.gamePlay();
    }

    @Test
    public void testFirstRoll(){

    }

    @Test
    public void testRemainingRolls(){

    }

    @Test
    public void testWin(){

    }

    @Test
    public void testLose(){

    }

    @Test
    public void testEnd(){

    }

    @Test
    public void testGetPointer(){

    }

    @Test
    public void testSetPointer(){

    }

    @Test
    public void testAddPlayer(){

    }

    @Test
    public void testRemovePlayer(){

    }

    @Test
    public void testExitTable(){

    }




}
