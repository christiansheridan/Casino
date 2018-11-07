package io.zipcoder.casino;

import io.zipcoder.casino.CardGame.BlackJack.BlackJack;
import io.zipcoder.casino.CardGame.BlackJack.BlackJackPlayer;
import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.CardGame.Deck;
import io.zipcoder.casino.CardGame.Face;
import io.zipcoder.casino.CardGame.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BlackJackTest {

    Deck deck = new Deck();
    Player player = new Player("Jack Black");
    BlackJack blackJack = new BlackJack(player);
    BlackJackPlayer testPlayer = blackJack.getPlayer(1);
    ArrayList<Card> testHand = testPlayer.getPlayerHand();

    @Test
    public void testHit() {
        blackJack.deal();
        blackJack.hit(testPlayer);

        int expected = 3;
        int actual = testHand.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSplit() {
        blackJack.setJustDealt(true);
        Card seven1 = new Card(Suit.HEARTS, Face.SEVEN);
        Card seven2 = new Card(Suit.SPADES, Face.SEVEN);

        testHand.add(seven1);
        testHand.add(seven2);

        blackJack.split(testPlayer);

        Face expected = testPlayer.getPlayerHand().get(0).getFace();
        Face actual = testPlayer.getSecondHand().get(0).getFace();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeal_player() {
        blackJack.deal();

        int expected = 2;
        int actual = testHand.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeal_dealer() {
        blackJack.deal();

        int expected = 2;
        int actual = blackJack.getDealer().getPlayerHand().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountPlayerHand_HasAce_OneOrEleven() {
        Card ace = new Card(Suit.HEARTS, Face.ACE);
        Card two = new Card(Suit.HEARTS, Face.TWO);
        Card six = new Card(Suit.HEARTS, Face.SIX);

        testHand.add(ace);
        testHand.add(two);
        testHand.add(six);

        int total_aceEqualsOne = 9;
        int total_aceEqualsEleven = 19;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(total_aceEqualsOne);
        expected.add(total_aceEqualsEleven);
        ArrayList<Integer>  actual = blackJack.countPlayerHand(testPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountPlayerHand_HasAce_CantBeEleven() {
        Card ace = new Card(Suit.HEARTS, Face.ACE);
        Card king = deck.draw();
        Card queen = deck.draw();

        testHand.add(ace);
        testHand.add(king);
        testHand.add(queen);

        int total_aceEqualsOne = 21;      // int total_aceEqualsEleven = 31;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(total_aceEqualsOne);
        ArrayList<Integer>  actual = blackJack.countPlayerHand(testPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountPlayerHand_NoAce() {
        Card king = deck.draw();
        Card two = new Card(Suit.HEARTS, Face.TWO);
        Card six = new Card(Suit.HEARTS, Face.SIX);

        testHand.add(king);
        testHand.add(two);
        testHand.add(six);

        int total = 18;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(total);
        ArrayList<Integer>  actual = blackJack.countPlayerHand(testPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testJustDealt() {
        blackJack.setJustDealt(false);

        boolean expected = false;
        boolean actual = blackJack.getJustDealt();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDoubleDown() {
        blackJack.setJustDealt(true);
        testPlayer.setInitialBet(blackJack.betAmount(50, testPlayer));
        blackJack.doubleDown(testPlayer);

        int expected = 100;
        int actual = testPlayer.getBetPot();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerHasAce_True() {
        Card ace = new Card(Suit.HEARTS, Face.ACE);

        testHand.add(ace);
        testHand.add(deck.draw());
        testHand.add(deck.draw());

        boolean expected = true;
        boolean actual = testPlayer.hasAce();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerHasAce_False() {
        testHand.add(deck.draw());
        testHand.add(deck.draw());
        testHand.add(deck.draw());

        boolean expected = false;
        boolean actual = testPlayer.hasAce();

        Assert.assertEquals(expected, actual);
    }



}
