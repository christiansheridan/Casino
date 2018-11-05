package io.zipcoder.casino;

public interface Gamble {
    int betAmount(int amount, Player player);

    void distributePot(int amount, Player player);
}
