package io.zipcoder.casino.CardGame.Solitaire;

import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.CardGame.CardGame;
import io.zipcoder.casino.CardGame.Deck;
import io.zipcoder.casino.Player;

public class Solitaire extends CardGame {

    private Player player;
    private Tableau tableau;
    private Foundation foundation;
    private java.util.Stack wastepile;

    public static Deck solitaireDeck = new Deck();


    public Solitaire(Player player) {
        this.player = player;
    }

    public void start(){

    }

    public void end() {

    }

    public void takeATurn() {

    }

    public void addPlayer() {

    }

    public void removePlayer() {

    }

    public void moveable() {
    }

    public void receivable() {
    }

    public Card draw() {
        return solitaireDeck.draw();
    }

    public void flip() {
        // shoulder technically be card.setCovered(false); or something like that
        boolean covered = false;
    }

}
