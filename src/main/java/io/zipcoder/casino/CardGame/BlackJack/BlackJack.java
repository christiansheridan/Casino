package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.CardGame.CardGame;
import io.zipcoder.casino.Interfaces.Gamble;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {

    private ArrayList<BlackJackPlayer> blackJackPlayers;
    private int minBet;
    private ArrayList<Card> wastepile;
    private java.util.ArrayList<Card> dealerHand;

    public BlackJack(Player player) {
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(player);
        this.blackJackPlayers.add(blackJackPlayer);
    }

    // basically draw
    public Card hit() {
        return null;
    }

    public void flip() {
        // shoulder technically be card.setCovered(false); or something like that
        boolean covered = false;
    }

    public void split() {
        // must be the same card value
    }

    public void doubleDown() {
        // must be right after the first daeling
    }

    public void stand() {
    }

    public int countHand() {
        return 0;
    }

    public void deal() {
    }

    public void start() {

    }

    public void end() {

    }

    public void takeATurn() {

    }

    public void addPlayer() {

    }

    public void removePlayer() {

    }

    public int betAmount(int amount, Player player) {
        return 0;
    }

    public void distributePot(int amount, Player player) {

    }
}
