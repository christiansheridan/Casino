package io.zipcoder.casino.CardGame.Solitaire;

import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.CardGame.Card.toCard;

public class SolitaireTest {
    Solitaire s = new Solitaire(new Player("Murphy"));

    @Test
    public void testfind(){
        s.resetDeck();
        s.tab1.add(toCard("Ace", "Hearts"));
        s.tab2.add(toCard("five","diamonds"));

        System.out.println(s.findTab(toCard("Ace","Hearts")).stack.peek());
    }
    @Test
    public void testPull(){
        s.resetDeck();
        s.tab1.add(toCard("Ace", "Hearts"));
        s.tab2.add(toCard("five","diamonds"));

        Integer preSize = s.tab1.size();
        s.pull(toCard("Ace","Hearts")); //main method tested
        Integer postSize = s.tab1.size();

        Integer actual = preSize - postSize;
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void drawCard() {
        s.drawCard();
        System.out.println(s.wastePile.peek().toString());
        Assert.assertEquals(1,s.wastePile.size());
    }

    @Test
    public void pullFromWaste() {
        s.resetDeck();
        s.drawCard();
        Card c = s.pullFromWaste().pop();
        String actual = c.toString();
        String expected = "CLUBS-KING";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeal(){
        s.resetDeck();
        s.deal();
        int i=0;
        for (Tableau tab : s.arrayTabs){
            System.out.println("tab " + i); i++;
            tab.stack.forEach(e -> System.out.println(e));

        Assert.assertTrue(s.arrayTabs[0].size() == 1);
        Assert.assertTrue(s.arrayTabs[1].size() == 2);
        Assert.assertTrue(s.arrayTabs[2].size() == 3);
        Assert.assertTrue(s.arrayTabs[3].size() == 4);
        Assert.assertTrue(s.arrayTabs[4].size() == 5);
        Assert.assertTrue(s.arrayTabs[5].size() == 6);
        Assert.assertTrue(s.arrayTabs[6].size() == 7);
        Assert.assertTrue(s.solitaireDeck.deckOfCards.size() == (52-28));
        }
    }

    @Test
    public void testCoverage(){

    }
}