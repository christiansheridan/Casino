package io.zipcoder.casino.CardGame;

public class Card {

    private Suit suit;
    private boolean isBlack;
    private Face face;
    private boolean covered;

    public Card(Suit suit, Face face){
        this.suit = suit;
        this.face = face;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public Card drawCard() {
        return null;
    }

    public void shuffleDeck() {
    }

    @Override
    public String toString(){
        return suit + "-" + face;
    }
}
