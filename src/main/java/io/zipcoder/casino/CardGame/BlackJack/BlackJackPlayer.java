package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.Player;

public class BlackJackPlayer {

    private Player player;

    private int initialBet;
    private int handValue;
    private java.util.ArrayList<Card> playerHand;
    private int betPot;

    public BlackJackPlayer(Player player) {
        this.player = player;
    }

}
