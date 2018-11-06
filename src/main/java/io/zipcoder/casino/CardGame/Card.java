package io.zipcoder.casino.CardGame;

import java.util.Objects;

public class Card {

    private Suit suit;
    private boolean isBlack;
    private Face face;
    private boolean covered;

    public Card(Suit suit, Face face){
        this.suit = suit;
        this.face = face;
        setBlack();
    }

    public static Card toCard(String face, String suit){
        return new Card(Suit.valueOf(suit.toUpperCase()), Face.valueOf(face.toUpperCase()));
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

    private void setBlack(){
        if(this.getSuit().toString().equals("HEARTS") || this.getSuit().toString().equals("DIAMOND")) isBlack = false;
        else isBlack = true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                face == card.face;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face);
    }
}
