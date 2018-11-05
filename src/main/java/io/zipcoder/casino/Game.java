package io.zipcoder.casino;

public interface Game {
    void start();

    void end();

    void takeATurn();

    void addPlayer();

    void removePlayer();
}
