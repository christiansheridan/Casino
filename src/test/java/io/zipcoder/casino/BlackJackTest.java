package io.zipcoder.casino;

import io.zipcoder.casino.CardGame.BlackJack.BlackJack;
import io.zipcoder.casino.CardGame.BlackJack.BlackJackPlayer;
import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.CardGame.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BlackJackTest {

    Deck deck = new Deck();
    Player player = new Player("Jack Black");
    BlackJack blackJack = new BlackJack(player);
    BlackJackPlayer testPlayer = blackJack.getPlayer(0);
    ArrayList<Card> testHand = testPlayer.getPlayerHand();

    @Test
    public void testDeal() {
        blackJack.deal(testPlayer);

        int expected = 2;
        int actual = testHand.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountHand() {
        testPlayer.addToHand(deck.draw());
        testPlayer.addToHand(deck.draw());

        System.out.println(testHand);

        int expected = 25;
        int actual = blackJack.countHand(testPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testJustDealt() {
        blackJack.setJustDealt(false);
        System.out.println(blackJack.getJustDealt());
    }

    @Test
    public void testDoubleDown(){
        blackJack.setJustDealt(true);
        testPlayer.setInitialBet(blackJack.betAmount(50, testPlayer));
        blackJack.doubleDown(testPlayer);

        int expected = 100;
        int actual = testPlayer.getBetPot();

        Assert.assertEquals(expected, actual);
    }

}
