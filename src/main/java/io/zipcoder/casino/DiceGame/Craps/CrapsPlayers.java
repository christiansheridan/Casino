package io.zipcoder.casino.DiceGame.Craps;

import io.zipcoder.casino.Player;

public class CrapsPlayers {

        private Player player;
        private int wallet;
        private int initialBet;
        private int rollValue;
        private int betPot;

        public CrapsPlayers(Player player) {
            this.player = player;
            this.initialBet = 0;
            this.rollValue = 0;
            this.betPot = 0;
        }

        public Player getPlayer() {
            return this.player;
        }

        public void addToBetPot(int amount) {
            betPot += amount;
            this.player.setWallet(player.getWallet()- amount);
        }

        public int getInitialBet() {
            return this.initialBet;
        }

        public void setInitialBet(int amount){
            this.initialBet = amount;
        }


        public void setWallet(int wallet) {
            this.wallet = wallet;
    }

        public int getWallet() {
            return wallet;
    }
}
