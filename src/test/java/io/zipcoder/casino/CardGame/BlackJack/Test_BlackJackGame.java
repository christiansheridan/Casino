package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player;

import java.util.Scanner;

public class Test_BlackJackGame {

    public static void main(String[] args) {
        Player player = new Player("Theta Thunder the III");

        BlackJack blackJack = new BlackJack(player);
        BlackJackPlayer blackJackPlayer = blackJack.getPlayer(1);

        blackJack.start();
        boolean flag = true;

        blackJack.deal();

        while (flag) {
            Scanner reader = new Scanner(System.in);
            System.out.println("\n~~~~~~~~~~~~~~~~~~~\n\nWhat do you want to do?\n\nHit - Stand - Double Down - Split - Quit");
            String inputResponse = reader.nextLine();

            String response = inputResponse.toUpperCase();

            switch (response) {
                case "HIT":
                    blackJack.hit(blackJackPlayer);
                    if (blackJackPlayer.getHandValue() > 21) {
                        flag = false;
                    }
                    break;
                case "STAND":
                    blackJack.stand();
                    break;
                case "DOUBLE DOWN":
                    break;
                case "SPLIT":
                    break;
                case "QUIT":
                    flag = false;
                    break;
                default:
                    System.out.println("Input unknown, please try again");
                    break;
            }
        }


    }
}
