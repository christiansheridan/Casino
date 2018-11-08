package io.zipcoder.casino;

// BlackJack
// Solitaire
// Craps
// Roulette?
// Slot Machine?

// Jackpot option? Low chance but player wins $1mil
//

import io.zipcoder.casino.CardGame.BlackJack.BlackJack;
import io.zipcoder.casino.DiceGame.Craps.Craps;
import io.zipcoder.casino.CardGame.Solitaire.Solitaire;
import io.zipcoder.casino.Interfaces.Game;

import java.util.Scanner;

public final class Casino_test {

    private final static Casino_test instance = new Casino_test();

    private Player player;

    private final String casinoName = "Thunder Theta";

    private Casino_test() {
    }

    public void chooseGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWhat game would you like to play?\n<< BlackJack - Solitaire - Craps - Leave >>");
        String userInput = scanner.nextLine();
        String input = userInput.toUpperCase();

        boolean flag = true;

        while (flag) {
            switch (input) {
                case "SOLITAIRE":
                    break;
                case "BLACKJACK":
                    BlackJack blackJack = new BlackJack(player);
                    System.out.println("\nHi " + instance.getPlayer().getName() + "! Welcome to BlackJack!\n\nThe minimum bet is $50.\n");
                    flag = false;
                    blackJack.start();
                    break;
                case "CRAPS":
                    Craps craps = new Craps(player);
                    flag = false;
                    craps.gamePlay();
                    break;
                case "LEAVE":
                    System.out.println("Thanks for coming to Thunder Theta, good bye!");
                    flag = false;
                    break;
                default:
                    System.out.println("I don't know what that game is. Please try again.");
                    break;
            }
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public static Casino_test getInstance() {
        return instance;
    }

    public String getCasinoName() {
        return this.casinoName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Casino_test instance = Casino_test.getInstance();
        System.out.println("Welcome to " + instance.getCasinoName() + "! What is your name?");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        instance.setPlayer(player);
        instance.chooseGame();
    }

//    private int money;
//    private String casinoName;
//    private Game game;
//    private Player player;
//    private String currentGame;
//
//    public void selectGame(int gameNum) {
//
//        switch (gameNum) {
//            case 1:
//                Game blackJack = new BlackJack(player);
//                break;
//            case 2:
//                Game solitaire = new Solitaire(player);
//                break;
//            case 3:
//                Game craps = new Craps(player);
//                break;
//            case 4:
//                leaveCasino();
//                break;
//            default:
//                System.out.println("Input unknown, please pick again.");
//                break;
//        }
//    }
//
//    public void leaveCasino() {
//    }

}
