package io.zipcoder.casino.CardGame;

public enum Face {

    ACE(1, 11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11, 10),
    QUEEN(12, 10),
    KING(13, 10);

    private int primaryValue;
    private int secondaryValue;

    Face(int primaryValue, int secondaryValue) {
        this.primaryValue = primaryValue;
        this.secondaryValue = secondaryValue;
    }

    Face(int primaryValue) {
        this.primaryValue = primaryValue;
        this.secondaryValue = primaryValue;     // even though they're the same, you wanna set it bc if you accdidentally call getSecondary on something w/o an initialized secondary then it'l return null
    }

    public int getPrimaryValue() {
        return primaryValue;
    }

    public int getSecondaryValue() {
        return secondaryValue;
    }

}
