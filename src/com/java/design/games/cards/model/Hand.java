package com.java.design.games.cards.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int size;
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.size = cards.size();
        this.cards = cards;
    }

    public int getSize() {
        return cards.size();
    }

    public List<Card> getCards() {
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

    public void addSingleCardToHand(Card card) {
        this.cards.add(card);
    }

    public void clear() {
        this.cards.clear();
    }

    public List<Integer> count() {
        List<Card> cards = this.cards;
        List<Integer> results = new ArrayList<Integer>();
        results.add(0);

        for(int i = 0; i < cards.size(); i++) {
            int resultsSize = results.size();
            for (int j = 0; j < resultsSize; j++) {
                int val = results.get(j);
                results.set(j, val + cards.get(i).getValue());

                if (cards.get(i).getValue() == 1) {
                    results.add(val + 11);
                }
            }
        }

        return results;
    }

    public int best() {
        List<Integer> results = this.count();
        int best = -1;
        int max = 0;

        for(int i = 0; i < results.size(); i++) {
            if (results.get(i) <= 21 && results.get(i) > best) best = results.get(i);
            if (results.get(i) > max) max = results.get(i);
        }

        if(best != -1) {
            return best;
        } else {
            return max;
        }
    }
}
