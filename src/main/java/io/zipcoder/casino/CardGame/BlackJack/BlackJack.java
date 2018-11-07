package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Card;
import io.zipcoder.casino.CardGame.CardGame;
import io.zipcoder.casino.CardGame.Deck;
import io.zipcoder.casino.CardGame.Face;
import io.zipcoder.casino.Interfaces.Gamble;
import io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends CardGame implements Gamble {

    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();
    private final int minBet = 50;
    private ArrayList<Card> wastepile = new ArrayList<>();
    private Deck deck = new Deck();
    private boolean justDealt = false;
    private int numOfTurns = 0;
    private BlackJackPlayer dealer = new BlackJackPlayer(new Dealer());


    public BlackJack(Player player) {
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(player);
        blackJackPlayers.add(dealer);
        this.blackJackPlayers.add(blackJackPlayer);
    }

    public void hit(BlackJackPlayer player) {
        setJustDealt(false);
        Card card = deck.draw();
        player.addToHand(card);

        if (countPlayerHand(player).get(0) > 21 || (countPlayerHand(player).size() == 2 && countPlayerHand(player).get(1) > 21)) {
            System.out.println("Your Current Hand: \n" + formatHand(player.getPlayerHand()) + "\nHand Value: " + formatHandValue(countPlayerHand(player)) + "\nToo high, you lose!");
        } else {
            System.out.println("Your Current Hand: \n" + formatHand(player.getPlayerHand()) + "\nHand Value: " + formatHandValue(countPlayerHand(player)));
        }
    }

//    public void flip() {
//        // shoulder technically be card.setCovered(false); or something like that
//        boolean covered = false;
//    }

    public void split(BlackJackPlayer player) {

        System.out.println(player.getPlayerHand() + "\n");

        Card movingCard = player.getPlayerHand().get(1);

        if (justDealt && player.getPlayerHand().get(0).getFace() == player.getPlayerHand().get(1).getFace()) {
            ArrayList<Card> newHand = player.createNewHand();
            newHand.add(movingCard);
            player.getPlayerHand().remove(movingCard);
        }

        System.out.println(player.getPlayerHand() + " " + player.getSecondHand());
        setJustDealt(false);

        // must be the same card value
    }

    public void doubleDown(BlackJackPlayer blackJackPlayer) {
        if (getJustDealt() == true) {
            blackJackPlayer.addToBetPot(blackJackPlayer.getInitialBet());
        }

        setJustDealt(false);
        // must be right after deal, and you can only get one more card
    }

    public void stand() {
        endTurn();
        // (end turn?) what does "take a turn" actually initiate
    }

    public int calculate_AceIsOne(BlackJackPlayer player) {
        ArrayList<Card> playerHand = player.getPlayerHand();
        int aceIsOne = 0;

        for (int i = 0; i < player.getPlayerHand().size(); i++) {
            if (playerHand.get(i).getFace() == Face.ACE) {
                aceIsOne += playerHand.get(i).getFace().getPrimaryValue();
            } else {
                aceIsOne += playerHand.get(i).getFace().getSecondaryValue();
            }
        }

        return aceIsOne;
    }

    public int calculate_Standard(BlackJackPlayer player) {
        ArrayList<Card> playerHand = player.getPlayerHand();
        int aceIsEleven = 0;

        for (int i = 0; i < player.getPlayerHand().size(); i++) {
            aceIsEleven += playerHand.get(i).getFace().getSecondaryValue();
        }

        return aceIsEleven;
    }

    public ArrayList<Integer> countPlayerHand(BlackJackPlayer player) {
        ArrayList<Integer> handSum = new ArrayList<>();
        Integer aceIsOne;
        Integer aceIsEleven;
        Integer noAce;

        if (player.hasAce() && calculate_Standard(player) > 21) {
            player.setHandValue(calculate_AceIsOne(player));
            aceIsOne = player.getHandValue();
            handSum.add(aceIsOne);

        } else if (player.hasAce() && calculate_Standard(player) < 21) {
            player.setHandValue(calculate_AceIsOne(player));
            aceIsOne = player.getHandValue();
            handSum.add(aceIsOne);

            player.setHandValue(calculate_Standard(player));
            aceIsEleven = player.getHandValue();
            handSum.add(aceIsEleven);

        } else {
            player.setHandValue(calculate_Standard(player));
            noAce = player.getHandValue();
            handSum.add(noAce);
        }

        return handSum;
    }

    public void deal() {
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            for (BlackJackPlayer player : this.blackJackPlayers) {
                Card card = deck.draw();
                player.addToHand(card);
            }
        }

        System.out.println("Your Current Hand: \n" + formatHand(this.blackJackPlayers.get(1).getPlayerHand()) + "\nHand Value: " + formatHandValue(countPlayerHand(this.blackJackPlayers.get(1))) + "\n");
        System.out.println("Dealer's Current Hand: \nMYSTERY-CARD || " + formatHand(dealer.getDealerHand()) + "\nHand Value: ??" + "\n");

        setJustDealt(true);
    }

    public BlackJackPlayer getPlayer(int index) {
        return blackJackPlayers.get(index);
    }

    public BlackJackPlayer getDealer() {
        return dealer;
    }

    public void start() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter an initial bet: ");
        int initialBet = reader.nextInt();

        start(initialBet);
    }

    public void start(int initialBet) {
        // upon starting a new game, every player places a bet? make a loop???
        BlackJackPlayer blackJackPlayer = blackJackPlayers.get(0);
        if (initialBet < minBet) {
            System.out.println("TOo low");
        } else {
            blackJackPlayer.setInitialBet(betAmount(initialBet, blackJackPlayers.get(0)));
        }
    }

    public void end() {

    }

    public void takeATurn() {

    }

    // add to game interface?
    public void endTurn() {
    }

    public void addPlayer(Player player) {
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(player);
        this.blackJackPlayers.add(blackJackPlayer);
    }

    public void removePlayer(Player player) {
        for (BlackJackPlayer blackJackPlayer : blackJackPlayers) {
            if (blackJackPlayer.getPlayer() == player) {
                this.blackJackPlayers.remove(blackJackPlayer);
                break;
            }
        }
    }

    public int betAmount(int amount, BlackJackPlayer blackJackPlayer) {
        blackJackPlayer.addToBetPot(amount);
        return betAmount(amount, blackJackPlayer.getPlayer());
    }

    public int betAmount(int amount, Player player) {
        return amount;
    }

    public void distributePot(int amount, Player player) {

    }

    public boolean getJustDealt() {
        return this.justDealt;
    }

    public void setJustDealt(boolean justDealt) {
        this.justDealt = justDealt;
    }

    public String formatHand(ArrayList<Card> array) {
        String stringHand = "";

        String uglyArray = array.toString();

        for (int i = 0; i < uglyArray.length(); i++) {
            if (uglyArray.charAt(i) != ' ' && uglyArray.charAt(i) != '[' && uglyArray.charAt(i) != ']' && uglyArray.charAt(i) != ',') {
                stringHand += uglyArray.charAt(i);
            } else if (uglyArray.charAt(i) == ' ') {
                stringHand += " || ";
            }
        }

        return stringHand;
    }

    public String formatHandValue(ArrayList<Integer> array) {
        String stringHandValue = "";

        String uglyArray = array.toString();

        for (int i = 0; i < uglyArray.length(); i++) {
            if (uglyArray.charAt(i) != ' ' && uglyArray.charAt(i) != '[' && uglyArray.charAt(i) != ']' && uglyArray.charAt(i) != ',') {
                stringHandValue += uglyArray.charAt(i);
            } else if (uglyArray.charAt(i) == ' ') {
                stringHandValue += " or ";
            }
        }

        return stringHandValue;
    }

}
