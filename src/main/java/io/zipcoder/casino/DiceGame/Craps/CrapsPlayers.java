package io.zipcoder.casino.DiceGame.Craps;

import io.zipcoder.casino.Player;

public class CrapsPlayers {

        private Player player;

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
            return player;
        }

        public int getInitialBet() {
            return initialBet;
        }

        public void addToBetPot(int amount) {
            betPot += amount;
            this.player.setWallet(player.getWallet()- amount);
        }

        public int getBetPot() {
            return betPot;
        }

        public void setInitialBet(int amount){
            this.initialBet = amount;
        }

    }
