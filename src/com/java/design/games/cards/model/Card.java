package com.java.design.games.cards.model;

/**
 *
A Card class to encapsulate the value(or rank), suit, and associated card. Associated images are String relative paths.

 */
public class Card {

    int value;
    Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public void printThisCard() {
        System.out.println(this.value + " " + this.suit);
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return this.suit;
    }

}
