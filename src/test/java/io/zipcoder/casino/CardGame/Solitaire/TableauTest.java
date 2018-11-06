package io.zipcoder.casino.CardGame.Solitaire;

import io.zipcoder.casino.CardGame.Card;
import org.junit.Assert;
import org.junit.Test;
import sun.tools.jconsole.Tab;

import static io.zipcoder.casino.CardGame.Card.toCard;
import static io.zipcoder.casino.CardGame.Solitaire.Solitaire.solitaireDeck;
import static io.zipcoder.casino.CardGame.Solitaire.Tableau.tempStack;

public class TableauTest {

    Tableau stack1 = new Tableau();
    Tableau stack2 = new Tableau();

    @Test
    public void addTest() {
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());

        Integer actual = stack1.size();
        Integer expected = 4;

        for(Card c : stack1.stack) System.out.println(c.toString());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void pullTest() {
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());

        stack1.pull(toCard("Queen","Clubs"));
        Integer actual = tempStack.size();
        Integer expected = 3;

        for(Card c : stack1.stack) System.out.println(c.toString());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void placeTest() {
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());

        stack2.add(toCard("King","Hearts"));
        stack1.pull(toCard("Queen","Clubs"));
        stack2.place();
        Integer actual = stack2.size();
        Integer expected = 4;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void placeTest2() {
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());

        stack2.add(toCard("King","Hearts"));
        stack1.pull(toCard("JACK","Clubs"));
        stack2.place();
        Integer actual = stack2.size();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    //tests whether top card on the pulled-from stack is uncovered after pulling
    @Test
    public void unCoverTest() {
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.stack.forEach(e -> e.setCovered(true));
        stack1.add(solitaireDeck.draw());
        stack1.stack.peek().setCovered(false);

        for(Card c : stack1.stack) System.out.println("Stack 1 " + c.toString() + " " + c.isCovered());
        System.out.println("*******");

        stack2.add(toCard("Queen","Hearts"));

        stack1.pull(toCard("Jack","Clubs"));
        stack2.place();

        for(Card c : stack2.stack) System.out.println("Stack 2 " + c.toString() + " " + c.isCovered());
        System.out.println();
        for(Card c : stack1.stack) System.out.println("Stack 1 " + c.toString() + " " + c.isCovered());
        System.out.println();
        for(Card c : tempStack) System.out.println("tempStack " + c.toString() + " " + c.isCovered());
        Boolean actual = stack1.stack.peek().isCovered();
        Assert.assertFalse(actual);
    }

    @Test
    public void unCoverTest2() {
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.add(solitaireDeck.draw());
        stack1.stack.forEach(e -> e.setCovered(true));
        stack1.add(solitaireDeck.draw());
        stack1.stack.peek().setCovered(false);

        for(Card c : stack1.stack) System.out.println("Stack 1 " + c.toString() + " " + c.isCovered());
        System.out.println("\n** Before **** After **\n");

        stack2.add(toCard("King","Hearts"));

        stack1.pull(toCard("Queen","Clubs"));
        stack2.place();

        for(Card c : stack1.stack) System.out.println("Stack 1 " + c.toString() + " " + c.isCovered());
        System.out.println();
        for(Card c : stack2.stack) System.out.println("Stack 2 " + c.toString() + " " + c.isCovered());
        System.out.println();
        for(Card c : tempStack) System.out.println("tempStack " + c.toString() + " " + c.isCovered());
        Boolean actual = stack1.stack.peek().isCovered();
        Assert.assertFalse(actual);
    }
}