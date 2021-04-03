package com.java.design.game.card.deckgame;

import com.java.design.game.card.model.Card;
import com.java.design.game.card.model.Hand;

/**
 *
 * A Poker class Evaluates Hand for hands with 5 cards. Each hand needs its own instance of this class,
 * and it is created by passing the hand into the constructor
 * To evaluate a player's hand, pass Player.getHand() to the evaluator.
 */
public class Poker {
    private final int knownHands = 9;
    private String[] handNames;
    private boolean[] haveHandTypes;
    private int[] haveHandValues;

    private final Hand thisHand;

    public Poker(Hand hand) {
        this.thisHand = hand;
        evaluate();
    }

    public void evaluate() {
        handNames = new String[] {"Straight flush", "Four of a kind", "Full house", "Flush", "Straight", "Three of a kind", "Two pair", "One Pair","High card"} ;
        haveHandTypes = new boolean[9]; // 0:Straight flush, 1: Four of a kind, 2: Full house, 3: Flush, 4: Straight, 5: Three of a kind, 6: Two pair, 7: One pair, 8: High card
        haveHandValues = new int[9];

        discoverOfAKinds();
        discoverFullHouse();
        discoverFlushes();
        discoverStraights();

        printWhatThisHandHas();
    }

    private int[] matchValues() {
        int[] howMany = new int[13];

        for(Card c : thisHand.getCards()) {
            howMany[c.getValue() - 1]++;
        }
        return howMany;
    }

    private void discoverOfAKinds() {
        int[] howMany = matchValues();

        for(int i = 0; i < howMany.length; i++) {
            if(howMany[i] == 4) {
                haveHandTypes[1] = true;
            }
            if(howMany[i] == 3) {
                haveHandTypes[5] = true;
            }
            if(howMany[i] == 2) {
                if(haveHandTypes[7]){
                    haveHandTypes[6] = true;
                    // figure out the higher of the two
                } else {
                    haveHandTypes[7] = true;
                }
                if(haveHandValues[7] < i)
                    haveHandValues[7] = i;
            }
            if(howMany[i] == 1){
                haveHandTypes[8] = true;
                if(haveHandValues[8] < i)
                    haveHandValues[8] = i;
            }
        }
    }

    private void discoverFlushes() {
        // right off the bat, let's say the hand has a flush and prove ourselves wrong.
        boolean flush = true;
        for(int i = 0; i < thisHand.getCards().size() - 1; i++) {
            if(thisHand.getCards().get(i).getSuit() != thisHand.getCards().get(i + 1).getSuit()) {
                flush = false;
            }
        }
        haveHandTypes[3] = flush;
    }

    private void discoverFullHouse() {
        int[] howMany = matchValues();
        boolean two = false;
        boolean three = false;

        for(int i = 0; i < howMany.length; i++) {
            if(howMany[i] == 2) {
                two = true;
            }
            if(howMany[i] == 3) {
                three = true;
            }
        }
        if(two && three) {
            haveHandTypes[2] = true;
        }
    }

    private void discoverStraights() {
        int[] howMany = matchValues();
        int straight = 0;
        for(int i : howMany) {
            if( i >= 1 ){
                straight++;
            } else if ( i == 0 ) {
                straight = 0 ;
            }
            if(straight == 5) {
                haveHandTypes[4] = true;
            }
        }
    }

    public void printWhatThisHandHas() {
        for(int i = 0; i < knownHands; i++) {
            if(haveHandTypes[i]) {
                System.out.println(handNames[i]);
            }
        }
    }
}
