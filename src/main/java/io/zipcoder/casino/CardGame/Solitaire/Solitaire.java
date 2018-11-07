package io.zipcoder.casino.CardGame.Solitaire;

import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.CardGame.CardGame;
import io.zipcoder.casino.CardGame.Deck;
import io.zipcoder.casino.Player;

import java.util.Stack;

import static io.zipcoder.casino.CardGame.Solitaire.Tableau.tempStack;

public class Solitaire extends CardGame {
    //clean up.

    //create setting for 3 card draw. which will affect the draw method.
    private Player player;
    public Tableau tab1, tab2, tab3, tab4, tab5, tab6, tab7;
    private Foundation foundation;
    public Stack<Card> wastePile;
    public Tableau[] arrayTabs;

    public Solitaire(Player player) {
        this.player = player;
        wastePile = new Stack<>();
        tab1 = new Tableau();
        tab2 = new Tableau();
        tab3 = new Tableau();
        tab4 = new Tableau();
        tab5 = new Tableau();
        tab6 = new Tableau();
        tab7 = new Tableau();
        arrayTabs = new Tableau[]{tab1, tab2, tab3, tab4, tab5, tab6, tab7};
    }

    public static Deck solitaireDeck = new Deck();

    public void deal() {
        solitaireDeck.shuffle();
        for (int i = 0; i < arrayTabs.length; i++) {
            for (int j = 0; j < arrayTabs.length; j++) {
                if (j >= i) arrayTabs[j].add(draw());
                if (j != i) arrayTabs[j].stack.peek().setCovered(true);
            }
        }
        for(Tableau tab : arrayTabs) tab.stack.peek().setCovered(false);
    }

    public void drawCard(){
        wastePile.push(solitaireDeck.draw());
    }

    public Stack<Card> pullFromWaste(){
        tempStack.push(wastePile.pop());
        return tempStack;
    }

    public Stack<Card> pull(Card c){
        return findTab(c).pull(c);
    }

    public Tableau findTab(Card c){
        for (Tableau tab : arrayTabs)
            if (tab.stack.contains(c))
                return tab;
        return null;
    }

    public void start(){

    }

    public void end() {

    }

    public void takeATurn() {

    }

    public void addPlayer(Player player) {

    }

    public void removePlayer(Player player) {

    }

    public void moveable() {
    }

    public void receivable() {
    }

    public Card draw() {
        return solitaireDeck.draw();
    }

    public void resetDeck(){
        solitaireDeck = new Deck();
    }

    public void flip() {
        // shoulder technically be card.setCovered(false); or something like that
        boolean covered = false;
    }

}
