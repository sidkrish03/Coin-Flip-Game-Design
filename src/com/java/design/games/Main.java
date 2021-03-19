package com.java.design.games;

import com.java.design.games.cards.model.CardGamePlayer;
import com.java.design.games.cards.model.Deck;
import com.java.design.games.minesweeper.game.Minesweeper;
import com.java.design.games.minesweeper.model.Board;
import com.java.design.games.minesweeper.model.DifficultyLevel;
import com.java.design.games.minesweeper.model.MineSweeperPlayer;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Game. Type Game Number: ");
        System.out.println("1. Minesweeper");
        System.out.println("2. CoinFlip");

        while(sc.hasNext()) {
            int game = Integer.parseInt(sc.nextLine());

            // TODO: while loop doesn't break even after game has ended

            switch (game) {
                case 1:
                    playMinesweeper();
                    break;
                case 2:
                    playCoinFlip();
                    break;
                default:
                    System.out.println("Invalid Game Selected");
            }
        }
    }

    private static void playMinesweeper() throws InterruptedException {
        String playerName = MineSweeperPlayer.getPlayerNameFromUser();
        MineSweeperPlayer mineSweeperPlayer = new MineSweeperPlayer(playerName);
        DifficultyLevel level = DifficultyLevel.getDifficultyLevelFromUser();
        Minesweeper minesweeper = new Minesweeper(level);
        Board board = minesweeper.getBoard();
        board.printBoard();
        minesweeper.playGame(mineSweeperPlayer);
    }

    private static void playCoinFlip() {

    }

    public static void playCardGame() {
        Deck testDeck = new Deck();
        testDeck.shuffleDeck();

        //d.printDeck();

        //Card a = d.removeTopCard();
        //a.printThisCard();

        //Hand testHand = testDeck.dealHand(5);
        //testHand.printHand();

        CardGamePlayer testPlayer1 = new CardGamePlayer(1);
        testPlayer1.setHand(testDeck.dealHand(26));
        testPlayer1.printCurrentHand();

        CardGamePlayer testPlayer2 = new CardGamePlayer(2);
        testPlayer2.setHand(testDeck.dealHand(26));
        testPlayer2.printCurrentHand();

        System.out.println("Size of deck now: " + testDeck.getSize());
    }
}
