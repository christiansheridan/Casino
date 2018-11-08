package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_BlackJackGame {

    public static void main(String[] args) {
//        Player player = new Player("Theta Thunder the III");
//        Scanner scanner = new Scanner(System.in);
//
        Player player = new Player("Theta Thunder the III");
        BlackJack blackJack = new BlackJack(player);
//
//        BlackJackPlayer blackJackPlayer = blackJack.getPlayer(1);
//        BlackJackPlayer dealer = blackJack.getDealer();
//
//        BlackJackPlayer activePlayer;
//
        System.out.println("\nWelcome to BlackJack!\n\nThe minimum bet is $50.");
        blackJack.start();
//
//        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nGAME START - DEALING CARDS");
//        blackJack.deal();
//
//        int turnNumber = blackJack.getNumOfTurns();
//        int stands = blackJack.getStands();
//
//        boolean flag = true;
//
//        while (flag) {
//            if (turnNumber % 2 == 1) {
//                activePlayer = dealer;
//            } else {
//                activePlayer = blackJackPlayer;
//            }
//
//            ArrayList<Integer> handValue = blackJack.countPlayerHand(activePlayer);
//
//            if (blackJack.getJustDealt()) {
//                if (dealer.getHandValue() == 21) {
//                    System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer's Current Hand: \n\n" + blackJack.formatHand(dealer.getPlayerHand()) + "\n\nDealer's Hand Value: " + dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nBlackjack! Dealer wins!");
//                    player.setWallet(player.getWallet() - (blackJackPlayer.getBetPot() * 2));
//                    System.out.println("\nYou Lost $" + blackJackPlayer.getBetPot() * 2 + "\nCurrent Wallet: $" + player.getWallet());
//                    flag = false;
//                } else if (blackJackPlayer.getHandValue() == 21) {
//                    System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Hand: \n\n" + blackJack.formatHand(blackJackPlayer.getPlayerHand()) + "\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nBlackjack! Player wins!");
//                    player.setWallet(player.getWallet() + (blackJackPlayer.getBetPot() * 2));
//                    System.out.println("\nYou Won $" + blackJackPlayer.getBetPot() * 2 + "\nCurrent Wallet: $" + player.getWallet());
//                    flag = false;
//                }
//            }
//
//            if (activePlayer == blackJackPlayer && stands < 2) {
//
//                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer's Current Hand: \n\nMYSTERY-CARD || " + blackJack.formatHand(dealer.getDealerHand()) + "\n\nDealer's Hand Value: ??" +
//                        "\n\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Hand: \n\n" + blackJack.formatHand(blackJackPlayer.getPlayerHand()) + "\n\nYour Hand Value: " + blackJack.formatHandValue(handValue) +
//                        "\n\n~~~~~~~~~~~~~~~~~~~\n\nYOUR TURN" + "\n\n~~~~~~~~~~~~~~~~~~~\n\nWhat do you want to do?\n<< Hit - Stand - Double Down - Split - Quit >>");
//                String inputResponse = scanner.nextLine();
//                String response = inputResponse.toUpperCase();
//
//                switch (response) {
//                    case "HIT":
//                        blackJack.hit(blackJackPlayer);
//
//                        if (blackJackPlayer.getHandValue() > 21) {
//                            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Hand: \n\n" + blackJack.formatHand(blackJackPlayer.getPlayerHand()) + "\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nToo high, you lose!");
//                            player.setWallet(player.getWallet() - blackJackPlayer.getBetPot());
//                            System.out.println("\nYou Lost $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + player.getWallet());
//                            flag = false;
//                        } else if (blackJackPlayer.getHandValue() == 21) {
//                            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Current Hand: \n\n" + blackJack.formatHand(blackJackPlayer.getPlayerHand()) + "\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nYou win!!! YAYAYAYAYAYAYYAYAYAYAYAYYY");
//                            player.setWallet(player.getWallet() + blackJackPlayer.getBetPot());
//                            System.out.println("\nYou Won $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + player.getWallet());
//                            flag = false;
//                        }
//                        break;
//                    case "STAND":
//                        blackJack.setNumOfTurns(turnNumber++);
//                        blackJack.stand();
//                        stands++;
//                        break;
//                    case "DOUBLE DOWN":
//                        blackJack.doubleDown(activePlayer);
//                        break;
//                    case "SPLIT":
//                        blackJack.split(activePlayer);
//                        break;
//                    case "QUIT":
//                        flag = false;
//                        break;
//                    default:
//                        System.out.println("Input unknown, please try again");
//                        break;
//                }
//            } else if (activePlayer == dealer && stands < 2) {
//
//                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDEALER'S TURN");
//
//                if (dealer.getHandValue() > 15 && dealer.getHandValue() < 21) {
//                    blackJack.setNumOfTurns(turnNumber++);
//                    blackJack.stand();
//                } else {
//                    blackJack.hit(dealer);
//
//                    if (dealer.getHandValue() > 21) {
//                        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer's Current Hand: \n\n" + blackJack.formatHand(dealer.getPlayerHand()) + "\n\nDealer's Hand Value: " + dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nDealer bust, you win!");
//                        player.setWallet(player.getWallet() + blackJackPlayer.getBetPot());
//                        System.out.println("\nYou Won $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + player.getWallet());
//                        flag = false;
//                    } else if (dealer.getHandValue() == 21) {
//                        System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nDealer's Current Hand: \n\n" + blackJack.formatHand(dealer.getPlayerHand()) + "\n\nDealer's Hand Value: " + dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nBlackjack! Dealer wins!");
//                        player.setWallet(player.getWallet() - blackJackPlayer.getBetPot());
//                        System.out.println("\nYou Lost $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + player.getWallet());
//                        flag = false;
//                    } else if (handValue.get(0) < 21 || (handValue.size() > 2 && handValue.get(1) < 21)) {
//                        blackJack.setNumOfTurns(turnNumber++);
//                        blackJack.stand();
//                    }
//                }
//                stands++;
//
//            } else if (stands == 2) {
//                System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\n  ...............\n  ...............\n  ...............\n  ...............\n  ...............\n  ...............\n    Calculating\n  ...............\n  ...............\n  ...............\n  ...............\n  ...............\n  ...............\n");
//
//                if (blackJackPlayer.getHandValue() > dealer.getHandValue()) {
//                    System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\nDealer's Hand Value: " + dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nYou win!");
//                    player.setWallet(player.getWallet() + blackJackPlayer.getBetPot());
//                    System.out.println("\nYou Won $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + player.getWallet());
//                } else if (blackJackPlayer.getHandValue() < dealer.getHandValue()) {
//                    System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\nDealer's Hand Value: " + dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nDealer wins! You lose!");
//                    player.setWallet(player.getWallet() - blackJackPlayer.getBetPot());
//                    System.out.println("\nYou Lost $" + blackJackPlayer.getBetPot() + "\nCurrent Wallet: $" + player.getWallet());
//                } else if (blackJackPlayer.getHandValue() == dealer.getHandValue()) {
//                    System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nYour Hand Value: " + blackJackPlayer.getHandValue() + "\n\nDealer's Hand Value: " + dealer.getHandValue() + "\n\n~~~~~~~~~~~~~~~~~~~\n\nTie, no one wins");
//                    System.out.println("\nCurrent Wallet: $" + player.getWallet());
//                }
//                flag = false;
//            }
//        }
//
//        System.out.println("Would you like to play again?\n\n<<YES - NO>>");
//        String userInput = scanner.nextLine();
//        String input = userInput.toUpperCase();
//
//        switch (input) {
//            case "YES":
//                blackJack.start();
//                break;
//            case "NO":
//                System.out.println("BYYYYEEEEEE");
//                // go back to casino
//                break;
//        }
    }
}
