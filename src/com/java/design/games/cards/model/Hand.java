package com.java.design.games.cards.model;

import java.util.ArrayList;

public class Hand {
    private int size;
    private ArrayList<Card> cards;

    public Hand(ArrayList<Card> cards) {
        this.size = cards.size();
        this.cards = cards;
    }

    public int getSize() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void printHand() {
        for(Card card : cards) {
            System.out.println(card.value + " " + card.suit);
        }
    }

    public Card removeFirstCard() {
        return cards.remove(0);
    }

    public void addToHand(ArrayList<Card> newCards) {
        cards.addAll(newCards);
    }
}
