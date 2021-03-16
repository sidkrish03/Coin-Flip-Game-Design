package com.java.design.games.coinflip;
import java.util.Scanner;

public class CoinFlipGame {
    public static void main(String[] args) {
        // Create a coin game with the 2 players provided
        CoinFlip newCoinGame = new CoinFlip("Sid", "Jack");

        // Response from the user to either continue or end game
        String usersResponse;

        do {
            newCoinGame.startGame();
            System.out.println("Play Again? ");
            System.out.println("Please give 'y' or 'Y' for Yes");
            Scanner playGameAgain = new Scanner(System.in);
            usersResponse = playGameAgain.nextLine();
        } while ((usersResponse.startsWith("y")) || (usersResponse.startsWith("Y")));
    }
}
