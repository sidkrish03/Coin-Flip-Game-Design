package com.java.design.games.cards.model;

import java.util.ArrayList;

/**
 *
 * The controller class helps mediate between the Deck and Card Game Player models
 */
public class PlayController {

    Deck deck;
    CardGamePlayer player1;
    CardGamePlayer player2;
    Table table;
    GameState gameState;

    public PlayController(Deck deck, CardGamePlayer player1, CardGamePlayer player2) {
        this.deck = deck;
        this.player1 = player1;
        this.player2 = player2;

        initializeNewGame();
        System.out.println(" Initializing new game ");
        this.gameState = GameState.STABLE;
    }

    public boolean gameOver() {
        if(player1.handEmpty() || player2.handEmpty()) {
            this.gameState = GameState.OVER;
            System.out.println(" Player Hands are empty! Game is Over. ");
            return true;
        } else {
            return false;
        }
    }

    public void initializeNewGame() {
        // Reset the deck
        deck = new Deck();

        // Clear the table
        table = new Table(2);

        // Shuffle the cards
        deck.shuffleDeck();

        // Deal the cards
        player1.setHand(deck.dealHand(26));
        player2.setHand(deck.dealHand(26));
    }

    public void player1Action() { // Lay cards on table

        // First the player lays down a card on his/her side of the table
        table.layCard(player1.playCard(), player1.getNumber());
        System.out.println(" Player 1 has laid down a card ");

        // Then the computer lays down a card on its side of the table
        table.layCard(player2.playCard(), player2.getNumber());
        System.out.println(" Player 2 has laid down a card ");
    }

    public void processLatestTable() { // Separate from laying cards on table so that the view has a chance to display the cards
        switch ( whoWon() ) {
            case 1: // Player 1 wins
                player1.addToHand(table.pickupCards());
                this.gameState = GameState.STABLE;
                System.out.println(" Player 1 wins this round! Now Player 1 may pick up cards. ");
                break;
            case 2: // Player 2 wins
                player2.addToHand(table.pickupCards());
                this.gameState = GameState.STABLE;
                System.out.println(" Player 2 wins this round! Now Player 2 may pick up cards. ");
                break;
            case -1: // Tie
                // No player won this round yet, there is a tie.
                // Put one card out there face down
                // Allow the player to perform the play action again
                this.gameState = GameState.PLAYING;
                System.out.println(" No player won this round yet, it's a tie! ");
                System.out.println(" Dealer to put one card out there face down. ");
                System.out.println(" Player 1 can play now. ");
                break;
        }
    }

    public int whoWon() {
        if(table.getSideCards(1).get(table.getSideCards(1).size() - 1).value
                > table.getSideCards(2).get(table.getSideCards(2).size() - 1).value) {
            // Player 1 wins
            System.out.println(" Player 1 won! ");
            return 1;
        } else if(table.getSideCards(1).get(table.getSideCards(1).size() - 1).value
                < table.getSideCards(2).get(table.getSideCards(2).size() - 1).value) {
            // Computer wins
            System.out.println(" Player 2 won! ");
            return 2;
        } else {
            // There is a tie
            System.out.println(" It's a tie! ");
            return -1;
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public ArrayList<Card>[] getTableCards() {
        return table.getTableCards();
    }

}
