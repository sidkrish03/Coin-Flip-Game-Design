package com.java.design.games.cards.model;

/**
 *
 * The Play game class. Creates new instances of important MODELS, sends them to a new CONTROLLER.
 */
public class PlayGame {
    public static void main(String[] args) {

        // Create the CONTROLLER object and pass it the important MODELS
        PlayController playController = new PlayController(new Deck(), new CardGamePlayer(1), new CardGamePlayer(2));

    }
}
