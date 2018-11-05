package io.zipcoder.casino;

// BlackJack
// Solitaire
// Craps
// Roulette?
// Slot Machine?

// Jackpot option? Low chance but player wins $1mil

public class Casino {

    private int money;
    private String casinoName;
    private Game game;
    private Player player;
    private String currentGame;

    public void selectGame(int gameNum) {

        switch (gameNum) {
            case 1:
                Game blackJack = new BlackJack(player);
                break;
            case 2:
                Game solitaire = new Solitaire(player);
                break;
            case 3:
                Game craps = new Craps(player);
                break;
            case 4:
                leaveCasino();
                break;
            default:
                System.out.println("Input unknown, please pick again.");
                break;
        }
    }

    public void leaveCasino() {
    }

}
