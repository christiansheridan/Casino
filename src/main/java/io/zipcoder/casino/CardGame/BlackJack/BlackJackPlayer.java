package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class BlackJackPlayer {

    private Player player;

    private int initialBet;
    private int handValue;
    private ArrayList<Card> playerHand;
    private int betPot;

    public BlackJackPlayer(Player player) {
        this.player = player;
        this.handValue = 0;
        this.playerHand = new ArrayList<Card>();
        this.betPot = 0;
    }

    public void addToHand(Card card){
        playerHand.add(card);
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public Player getPlayer() {
        return player;
    }

    public int getInitialBet() {
        return initialBet;
    }

    public void addToBetPot(int amount) {
        betPot += amount;
    }

    public int getBetPot() {
        return betPot;
    }

    public void setInitialBet(int amount){
        this.initialBet = amount;
    }

}
