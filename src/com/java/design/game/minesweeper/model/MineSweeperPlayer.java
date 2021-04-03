package com.java.design.game.minesweeper.model;

import java.util.Scanner;

public class MineSweeperPlayer {
    private final String name;

    public MineSweeperPlayer(String newName) {
        this.name = newName;
    }

    public static String getPlayerNameFromUser() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        //Thread.sleep(3000);

        String playerName = sc.nextLine();
        return playerName;
    }
}
