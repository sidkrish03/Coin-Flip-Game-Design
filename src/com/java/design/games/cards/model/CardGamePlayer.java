package com.java.design.games.cards.model;

import java.util.ArrayList;

/**
 *
 * A Player class. Player's can have a player number, a Hand, and perform operations like adding cards to their hand, playing a card from their hand,
 * checking whether their hand is empty, ...
 *
 */
public class CardGamePlayer {
    private int number;
    private Hand currentHand;

    public CardGamePlayer(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setHand(Hand h) {
        this.currentHand = h;
    }

    public void addToHand(ArrayList<Card> newCards) {
        currentHand.addToHand(newCards);
    }

    public void printCurrentHand() {
        System.out.println("Player " + this.number);
        currentHand.printHand();
    }

    public boolean handEmpty() {
        if(currentHand.getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getCurrentHandSize() {
        return currentHand.getSize();
    }

    public Card playCard() {
        return currentHand.removeFirstCard();
    }

}
