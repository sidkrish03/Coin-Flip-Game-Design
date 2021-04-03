package com.java.design.game.card.deckgame;

import com.java.design.game.card.model.Card;
import com.java.design.game.card.model.Deck;
import com.java.design.game.card.model.Hand;

import java.util.ArrayList;
import java.util.List;

/**
 * BlackJack classic 21-
 * A BlackJack class Evaluates Hand for hands with card values upto 21. Each hand needs its own instance of this class,
 * and it is created by passing the hand into the constructor
 * To evaluate a player's hand, pass Player.getHand() to the evaluator.
 */
public class BlackJack {
    private final Deck deck;
    private final Hand playerHand;
    private final Hand bankHand;

    public boolean gameFinished = false;

    public BlackJack(Hand hand) {
        this.deck = new Deck();
        this.playerHand = hand;
        this.bankHand = hand;

    }

    public void evaluate() {


        // TODO : Write printWhatThisHandHas() with value sum of cards after each turn
        // printWhatThisHandHas();
    }

    public void reset() {
        this.playerHand.clear();
        this.bankHand.clear();
        this.gameFinished = false;

        try {
            this.playerHand.addSingleCardToHand(this.deck.draw());
            this.bankHand.addSingleCardToHand(this.deck.draw());
        } catch (Exception e) {
            System.out.println("The deck is empty.");
        }
    }

    public String getPlayerHandString() {
        return this.playerHand.toString();
    }

    public String getBankHandString() {
        return this.bankHand.toString();
    }

    public int getPlayerBest() {
        return this.playerHand.best();
    }

    public int getBankBest() {
        return this.bankHand.best();
    }

    public boolean isPlayerWinner() {
        if(this.playerHand.best() <= 21
                && (this.bankHand.best() < this.playerHand.best() || this.bankHand.best() > 21)
                && this.gameFinished) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBankWinner() {
        if(this.bankHand.best() <= 21
                && (this.playerHand.best() < this.bankHand.best() || this.playerHand.best() > 21)
                && this.gameFinished) {
            return true;
        } else {
            return false;
        }
    }

    public void playerDrawAnotherCard() {
        if(!this.isGameFinished()) {
            Card card = this.deck.draw();
            this.playerHand.addSingleCardToHand(card);
            if (this.playerHand.best() > 21) {
                this.gameFinished = true;
            }
        }
    }

    public void bankLastTurn() {
        if(!this.gameFinished) {
            if(this.playerHand.best() <= 21 && this.bankHand.best() <= 21) {
                while(this.bankHand.best() < this.playerHand.best() && this.bankHand.best() < 21) {
                    Card card = this.deck.draw();
                    this.bankHand.addSingleCardToHand(card);
                }
                this.gameFinished = true;
            }
        }
    }

    public boolean isGameFinished() {
        return this.gameFinished;
    }

    public List<Card> getPlayerCardList() {
        List<Card> originalList = this.playerHand.getCards();
        List<Card> copyList = new ArrayList<Card>(originalList);
        return copyList;
    }

    public List<Card> getBankCardList() {
        List<Card> originalList = this.bankHand.getCards();
        List<Card> copyList = new ArrayList<Card>(originalList);
        return copyList;
    }

//    public void printWhatThisHandHas() {
//        for(int i = 0; i < knownHands; i++) {
//            if(haveHandTypes[i]) {
//                System.out.println(handNames[i]);
//            }
//        }
//    }
}
