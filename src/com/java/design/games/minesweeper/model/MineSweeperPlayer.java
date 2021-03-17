package com.java.design.games.minesweeper.model;

import java.util.Scanner;

public class MineSweeperPlayer {
    private final String name;

    public MineSweeperPlayer(String newName) {
        this.name = newName;
    }

//    // Decide the winner
//    public void didPlayerWin(final Board board) {
//        if(board) {
//            System.out.println(name + " Won the game at " + difficultyLevel);
//        } else {
//            System.out.println(name + " Lost the game at " + difficultyLevel);
//        }
//    }

    public static String getPlayerNameFromUser() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        //Thread.sleep(3000);

        String playerName = sc.nextLine();
        return playerName;
    }
}
