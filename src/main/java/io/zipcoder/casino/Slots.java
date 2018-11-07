package io.zipcoder.casino;

public class Slots {

    String[] reels = new String[5];
    String[] names = {"♡","♢", "♤",
            "♧", "♬", "WIN", "♡","♢", "♤",
            "♧", "♬", "Kris", "Nhu", "Froilan",
            "Dolio",
            "Leon", "Wilhem", "WOW", "ZCW" };

    public Slots() {
        int bet;

    }

    public void FillReels(int bet){
        int win = 0;
        int zcw = 0;
        int getAll = 0;
        int payOut = 0;
        printScreen1();
        System.out.print("///\t\t\t|");
        for(int i = 0; i < reels.length; i++){
            reels[i] = names[(int)(Math.random() * 19)];
            if (reels[i] == "WIN"){
                win++;
            }
            if (reels[i] == "ZCW"){
                zcw++;
            }

            System.out.printf("| %8s |", reels[i]);
            if (i == reels.length - 1){
                System.out.println("|\t\t|\t\t///\t | |");
            }
        }

            printScreen2();


        payOut = amountWon(bet, win, zcw);

        System.out.println("\t\t\t\t\t\t\t\t\tYour bet: " + bet + "CHIPS");
        if (payOut > 0) {
            System.out.println("\t\t\t\t\t\t\t\t\tYOU WON: " + bet + "CHIPS");
        }



    }

    private int amountWon(int bet, int win, int zcw) {
        int payOut = 0;
        int winTotal = bet * win;
        int zcwTotal = (bet * 2) * zcw;
        payOut = winTotal + payOut;
        return payOut;
    }

    private void printScreen1() {
        System.out.println(" ////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///																				        ///");
        System.out.println("///								    THE THUNDER DOME							        ///");
        System.out.println("///																				        ///");
        System.out.println("///		    _____________________________________________________________________       ///  ___");
        System.out.println("///		    |																	|	    /// (   )");
        System.out.println("///		    |																	|	    ///	 | |");
        System.out.println("///		    |																	|	    ///	 | |");

    }

    private void printScreen2() {
        System.out.println("///		    |																	|	    ///__| |");
        System.out.println("///		    |																	|	    ///____|");
        System.out.println("///		    |___________________________________________________________________|	    ///");
        System.out.println("///																	                    ///");																			///
        System.out.println("///																                        ///");																			///
        System.out.println(" /////    	 															            /////");																			///
        System.out.println("  //////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("  /////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("  /////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("  /////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("  /////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("  /////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("  /////////////////////////////////////////////////////////////////////////////////////");
    }
}
