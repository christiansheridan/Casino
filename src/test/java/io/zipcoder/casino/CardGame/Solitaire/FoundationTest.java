package io.zipcoder.casino.CardGame.Solitaire;

import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.CardGame.Deck;
import io.zipcoder.casino.CardGame.Face;
import io.zipcoder.casino.CardGame.Suit;
import org.junit.Assert;
import org.junit.Test;

public class FoundationTest {



    Foundation foundation = new Foundation();
    Deck deck = new Deck();
    Card card  = new Card(Suit.CLUBS, Face.QUEEN);

    @Test
    public void addKingToQueenOnClubStackTest() {
        //GIVEN


        Card chosen = deck.deckOfCards.pop();
        foundation.tempStack.push(chosen);
        foundation.clubStack.push(card);
        foundation.whichSuit(foundation.tempStack);
        //WHEN

        Card expected = new Card(Suit.CLUBS, Face.KING);
        Card actual = foundation.clubStack.peek();


        //THEN
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addKingToQueenOfDiamondsStackTest() {
        //GIVEN


        Card tempCard  = new Card(Suit.DIAMONDS, Face.KING);
        Card cardOnFoundation  = new Card(Suit.DIAMONDS,
                Face.QUEEN);


        foundation.tempStack.push(tempCard);
        foundation.diamondStack.push(cardOnFoundation);
        foundation.whichSuit(foundation.tempStack);
        //WHEN

        Card expected = new Card(Suit.DIAMONDS, Face.KING);
        Card actual = foundation.diamondStack.peek();


        //THEN
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addKingToQueenInHeartStackTest() {
        Card tempCard  = new Card(Suit.HEARTS, Face.KING);
        Card cardOnFoundation  = new Card(Suit.HEARTS,
                Face.QUEEN);


        foundation.tempStack.push(tempCard);
        foundation.heartStack.push(cardOnFoundation);
        foundation.whichSuit(foundation.tempStack);
        //WHEN

        Card expected = new Card(Suit.HEARTS, Face.KING);
        Card actual = foundation.heartStack.peek();


        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addKingToQueenInSpadeStackTest() {
        Card tempCard  = new Card(Suit.SPADES, Face.KING);
        Card cardOnFoundation  = new Card(Suit.SPADES,
                Face.QUEEN);


        foundation.tempStack.push(tempCard);
        foundation.spadeStack.push(cardOnFoundation);
        foundation.whichSuit(foundation.tempStack);
        //WHEN

        Card expected = new Card(Suit.SPADES, Face.KING);
        Card actual = foundation.spadeStack.peek();


        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTenToQueenInSpadeStackTest() {
        Card tempCard  = new Card(Suit.SPADES, Face.KING);
        Card cardOnFoundation  = new Card(Suit.SPADES,
                Face.TEN);


        foundation.tempStack.push(tempCard);
        foundation.spadeStack.push(cardOnFoundation);
        foundation.whichSuit(foundation.tempStack);
        //WHEN

        Card expected = new Card(Suit.SPADES, Face.KING);
        Card actual = foundation.spadeStack.peek();


        //THEN
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void addAceToEmptyStackInClubStackTest() {
        Card tempCard  = new Card(Suit.CLUBS, Face.ACE);

        Foundation foundation1 = new Foundation();


        foundation1.tempStack.push(tempCard);

        foundation1.whichSuit(foundation1.tempStack);
        //WHEN

        Card expected = new Card(Suit.CLUBS, Face.ACE);
        Card actual = foundation1.clubStack.peek();


        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAceToEmptyStackInDiamondStackTest() {
        Card tempCard  = new Card(Suit.DIAMONDS, Face.ACE);

        Foundation foundation1 = new Foundation();


        foundation1.tempStack.push(tempCard);

        foundation1.whichSuit(foundation1.tempStack);
        //WHEN

        Card expected = new Card(Suit.DIAMONDS, Face.ACE);
        Card actual = foundation1.diamondStack.peek();


        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAceToEmptyStackInHeartStackTest() {
        Card tempCard  = new Card(Suit.HEARTS, Face.ACE);

        Foundation foundation1 = new Foundation();


        foundation1.tempStack.push(tempCard);

        foundation1.whichSuit(foundation1.tempStack);
        //WHEN

        Card expected = new Card(Suit.HEARTS, Face.ACE);
        Card actual = foundation1.heartStack.peek();


        //THEN
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void addAceToEmptyStackInSpadeStackTest() {
        Card tempCard  = new Card(Suit.SPADES, Face.ACE);

        Foundation foundation1 = new Foundation();


        foundation1.tempStack.push(tempCard);

        foundation1.whichSuit(foundation1.tempStack);
        //WHEN

        Card expected = new Card(Suit.SPADES, Face.ACE);
        Card actual = foundation1.spadeStack.peek();


        //THEN
        Assert.assertEquals(expected, actual);
    }

}