package io.zipcoder.casino;

public class Player {

    // cashmoney?
    private int wallet;
    private String name;

    public Player(String name) {
        this.wallet = 500;
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Player() { }



}
