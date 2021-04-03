package com.java.design.game;

import com.java.design.game.card.deckgame.BlackJack;
import com.java.design.game.card.deckgame.Poker;
import com.java.design.game.card.model.CardGamePlayer;
import com.java.design.game.card.model.Deck;
import com.java.design.game.card.model.Hand;
import com.java.design.game.card.model.PlayController;
import com.java.design.game.minesweeper.Minesweeper;
import com.java.design.game.minesweeper.model.Board;
import com.java.design.game.minesweeper.model.DifficultyLevel;
import com.java.design.game.minesweeper.model.MineSweeperPlayer;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Game. Type Game Number: ");
        System.out.println("1. Minesweeper");
        System.out.println("2. CoinFlip");

        while(sc.hasNext()) {
            int game = Integer.parseInt(sc.nextLine());

            switch (game) {
                case 1:
                    playMinesweeper();
                    break;
                case 2:
                    playCoinFlip();
                    break;
                case 3:
                    playCardGame();
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Card Game! ");
        System.out.println("Please choose a type of Card game: ");
        System.out.println("1. Poker ");
        System.out.println("2. BlackJack ");
        System.out.println("Type the corresponding game number to continue ");

        while(sc.hasNext()) {
            int game = Integer.parseInt(sc.nextLine());

            switch(game) {
                case 1:
                    PlayController pokerPlayController = new PlayController(new Deck(), new CardGamePlayer(1), new CardGamePlayer(2));
                    Deck pokerDeck = new Deck();
                    pokerDeck.shuffleDeck();

                    Hand pokerHand = pokerDeck.dealHand(5);
                    Poker poker = new Poker(pokerHand);

                    CardGamePlayer pokerPlayer1 = new CardGamePlayer(1);
                    pokerPlayer1.setHand(pokerDeck.dealHand(26));
                    pokerPlayer1.printCurrentHand();

                    CardGamePlayer pokerPlayer2 = new CardGamePlayer(2);
                    pokerPlayer2.setHand(pokerDeck.dealHand(26));
                    pokerPlayer2.printCurrentHand();

                    System.out.println("Size of deck now: " + pokerDeck.getSize());

                    break;
                case 2:
                    PlayController blackJackPlayController = new PlayController(new Deck(), new CardGamePlayer(1), new CardGamePlayer(2));
                    Deck blackJackDeck = new Deck();
                    blackJackDeck.shuffleDeck();

                    Hand blackJackHand = blackJackDeck.dealHand(5);
                    BlackJack blackJack = new BlackJack(blackJackHand);

                    // TODO: setupPlayer()

                    CardGamePlayer blackJackPlayer = new CardGamePlayer(1);
                    blackJackPlayer.setHand(blackJackDeck.dealHand(26));
                    blackJackPlayer.printCurrentHand();

                    CardGamePlayer blackJackDealer = new CardGamePlayer(2);
                    blackJackDealer.setHand(blackJackDeck.dealHand(26));
                    blackJackDealer.printCurrentHand();

                    System.out.println("Size of deck now: " + blackJackDeck.getSize());
                    break;
                default:
                    System.out.println("Invalid Game Selected. Please try again.");
            }
        }
    }
}
