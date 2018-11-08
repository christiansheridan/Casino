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
    int stands = 0;


    public BlackJack(Player player) {
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(player);
        blackJackPlayers.add(dealer);
        this.blackJackPlayers.add(blackJackPlayer);
        deck.shuffle();
    }

    public void hit(BlackJackPlayer player) {
        setJustDealt(false);
        Card card = deck.draw();
        player.addToHand(card);
        countPlayerHand(player);


        if (player == blackJackPlayers.get(1)) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYou Hit: " + card.toString());
        } else if (player == this.dealer) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer Hit: " + card.toString());
        }

    }

    public void split(BlackJackPlayer player) {

        Card movingCard = player.getPlayerHand().get(1);

        if (justDealt && player.getPlayerHand().get(0).getFace() == player.getPlayerHand().get(1).getFace()) {
            ArrayList<Card> newHand = player.createNewHand();
            newHand.add(movingCard);
            player.getPlayerHand().remove(movingCard);
        }

        setJustDealt(false);
    }

    public void doubleDown(BlackJackPlayer blackJackPlayer) {
        if (getJustDealt()) {
            blackJackPlayer.addToBetPot(blackJackPlayer.getInitialBet());
        }

        setJustDealt(false);
        // must be right after deal, and you can only get one more card
    }

    public void stand() {
        setJustDealt(false);
        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nStanding still!");
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

        for (int i = 0; i < 2; i++) {
            for (BlackJackPlayer player : this.blackJackPlayers) {
                Card card = deck.draw();
                player.addToHand(card);
                countPlayerHand(player);
            }
        }

        setJustDealt(true);
    }

    public BlackJackPlayer getPlayer(int index) {
        return blackJackPlayers.get(index);
    }

    public BlackJackPlayer getDealer() {
        return this.dealer;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("\nWould you like the hear the rules of the game?\n<< Yes - No - Quit >>");
        // String userInput = scanner.nextLine();
        int initialBet;
        // String input = userInput.toUpperCase();

        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nHow much would you like to bet?");
        initialBet = scanner.nextInt();
        start(initialBet);

//        switch (input) {
//            case "YES":
//                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nGoogle. Okay, let's begin!\n\nHow much would you like to bet?");
//                initialBet = scanner.nextInt();
//                start(initialBet);
//                break;
//            case "NO":
//                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nOkay, let's begin!\n\nHow much would you like to bet?");
//                initialBet = scanner.nextInt();
//                start(initialBet);
//                break;
//            case "QUIT":
//                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nk bye felicia");
//                // go back to casino??
//                break;
//            default:
//                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nPlease try again.");
//                start();
//                break;
//        }
    }

    public void start(int initialBet) {
        BlackJackPlayer blackJackPlayer = blackJackPlayers.get(1);

        if (initialBet < minBet) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nThe minimum bet is $50. Please try again.");
            start();
        } else {
            blackJackPlayer.setInitialBet(betAmount(initialBet, blackJackPlayers.get(1)));
        }

        // Player player = new Player("Theta Thunder the III");
        Scanner scanner = new Scanner(System.in);

        // BlackJack blackJack = new BlackJack(player);

        // BlackJackPlayer blackJackPlayer = blackJack.getPlayer(1);
        // BlackJackPlayer dealer = blackJack.getDealer();

        BlackJackPlayer activePlayer;
//
//        System.out.println("\nWelcome to BlackJack!\n\nThe minimum bet is $50.");
//        blackJack.start();

        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nGAME START - DEALING CARDS");
        deal();

        int turnNumber = getNumOfTurns();
        int stands = getStands();

        boolean flag = true;

        while (flag) {
            if (turnNumber % 2 == 1) {
                activePlayer = this.dealer;
            } else {
                activePlayer = blackJackPlayer;
            }

            ArrayList<Integer> handValue = countPlayerHand(activePlayer);

            if (turnNumber == 0 && this.dealer.getHandValue() == 21) {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer's Current Hand: \n\n" + formatHand(this.dealer.getPlayerHand()) + "\n\nDealer's Hand Value: " + this.dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nBlackjack! Dealer wins!");
                blackJackPlayer.getPlayer().setWallet(blackJackPlayer.getPlayer().getWallet() - (blackJackPlayer.getBetPot() * 2));
                System.out.println("\nYou Lost $" + blackJackPlayer.getBetPot() * 2 + "\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                flag = false;
            } else if (turnNumber == 0 && blackJackPlayer.getHandValue() == 21) {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Hand: \n\n" + formatHand(blackJackPlayer.getPlayerHand()) + "\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nBlackjack! Player wins!");
                blackJackPlayer.getPlayer().setWallet(blackJackPlayer.getPlayer().getWallet() + (blackJackPlayer.getBetPot() * 2));
                System.out.println("\nYou Won: $" + blackJackPlayer.getBetPot() * 2 + "\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                flag = false;
            } else if (activePlayer == blackJackPlayer && stands < 2) {

                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer's Current Hand: \n\nMYSTERY-CARD || " + formatHand(this.dealer.getDealerHand()) + "\n\nDealer's Hand Value: ??" +
                        "\n\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Hand: \n\n" + formatHand(blackJackPlayer.getPlayerHand()) + "\n\nYour Hand Value: " + formatHandValue(handValue) +
                        "\n\n~~~~~~~~~~~~~~~~~~~\n\nYOUR TURN" + "\n\n~~~~~~~~~~~~~~~~~~~\n\nWhat do you want to do?\n<< Hit - Stand - Double Down - Split - Quit >>");
                String inputResponse = scanner.nextLine();
                String response = inputResponse.toUpperCase();

                switch (response) {
                    case "HIT":
                        hit(blackJackPlayer);

                        if (blackJackPlayer.getHandValue() > 21) {
                            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Hand: \n\n" + formatHand(blackJackPlayer.getPlayerHand()) + "\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nToo high, you lose!");
                            blackJackPlayer.getPlayer().setWallet(blackJackPlayer.getPlayer().getWallet() - blackJackPlayer.getBetPot());
                            System.out.println("\nYou Lost $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                            flag = false;
                        } else if (blackJackPlayer.getHandValue() == 21) {
                            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Hand: \n\n" + formatHand(blackJackPlayer.getPlayerHand()) + "\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nYou win!!! YAYAYAYAYAYAYYAYAYAYAYAYYY");
                            blackJackPlayer.getPlayer().setWallet(blackJackPlayer.getPlayer().getWallet() + blackJackPlayer.getBetPot());
                            System.out.println("\nYou Won: $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                            flag = false;
                        }
                        break;
                    case "STAND":
                        setNumOfTurns(turnNumber++);
                        stand();
                        stands++;
                        break;
                    case "DOUBLE DOWN":
                        if (getJustDealt()) {
                            doubleDown(activePlayer);
                            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Bet: " + blackJackPlayer.getBetPot());
                        } else {
                            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYou can only double down right after the deal. Please choose another option.");
                        }
                        break;
                    case "SPLIT":
                        split(activePlayer);
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nok so the code itself works but idk how to actually implement it into the game without going crazy so plz choose something else");
                        break;
                    case "QUIT":
                        flag = false;
                        break;
                    default:
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nInput unknown, please try again");
                        break;
                }
            } else if (activePlayer == this.dealer && stands < 2) {

                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDEALER'S TURN");

                if (this.dealer.getHandValue() > 15 && this.dealer.getHandValue() < 21) {
                    setNumOfTurns(turnNumber++);
                    stand();
                } else {
                    hit(this.dealer);

                    if (this.dealer.getHandValue() > 21) {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer's Current Hand: \n\n" + formatHand(this.dealer.getPlayerHand()) + "\n\nDealer's Hand Value: " + this.dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nDealer bust, you win!");
                        blackJackPlayer.getPlayer().setWallet(blackJackPlayer.getPlayer().getWallet() + blackJackPlayer.getBetPot());
                        System.out.println("\nYou Won: $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                        flag = false;
                    } else if (this.dealer.getHandValue() == 21) {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer's Current Hand: \n\n" + formatHand(this.dealer.getPlayerHand()) + "\n\nDealer's Hand Value: " + this.dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nBlackjack! Dealer wins!");
                        blackJackPlayer.getPlayer().setWallet(blackJackPlayer.getPlayer().getWallet() - blackJackPlayer.getBetPot());
                        System.out.println("\nYou Lost $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                        flag = false;
                    } else if (handValue.get(0) < 21 || (handValue.size() > 2 && handValue.get(1) < 21)) {
                        setNumOfTurns(turnNumber++);
                        stand();
                    }
                }
                stands++;

            } else if (stands == 2) {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDETERMINING WINNER...");

                if (blackJackPlayer.getHandValue() > this.dealer.getHandValue()) {
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\nDealer's Hand Value: " + this.dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nYou win!");
                    blackJackPlayer.getPlayer().setWallet(blackJackPlayer.getPlayer().getWallet() + blackJackPlayer.getBetPot());
                    System.out.println("\nYou Won: $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                } else if (blackJackPlayer.getHandValue() < this.dealer.getHandValue()) {
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\nDealer's Hand Value: " + this.dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nDealer wins! You lose!");
                    blackJackPlayer.getPlayer().setWallet(blackJackPlayer.getPlayer().getWallet() - blackJackPlayer.getBetPot());
                    System.out.println("\nYou Lost $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                } else if (blackJackPlayer.getHandValue() == this.dealer.getHandValue()) {
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\nDealer's Hand Value: " + this.dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nTie, no one wins");
                    System.out.println("\nCurrent Wallet: $" + blackJackPlayer.getPlayer().getWallet());
                }
                flag = false;
            }
        }

        this.dealer.resetHand();
        blackJackPlayer.resetHand();
        setNumOfTurns(0);
        setStands(0);
        blackJackPlayer.setInitialBet(0);
        blackJackPlayer.setBetPot(0);

        System.out.println("\n\nWould you like to play again?\n<< Yes - No >>");
        String userInput = scanner.nextLine();
        String input = userInput.toUpperCase();

        switch (input) {
            case "YES":
                start();
                break;
            case "NO":
                System.out.println("\n\nBYYYYEEEEEE");
                // go back to casino
                break;
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

    public ArrayList<BlackJackPlayer> getBlackJackPlayers() {
        return blackJackPlayers;
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

    public int getStands() {
        return stands;
    }

    public void setStands(int stands) {
        this.stands = stands;
    }

    public int getNumOfTurns() {
        return numOfTurns;
    }

    public void setNumOfTurns(int numOfTurns) {
        this.numOfTurns = numOfTurns;
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
