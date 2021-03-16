package com.java.design.games.minesweeper.model;

import java.util.Scanner;

public enum DifficultyLevel {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED;

    public static DifficultyLevel getDifficultyLevelFromUser() {
        Scanner sc = new Scanner(System.in);
        DifficultyLevel difficultyLevel = DifficultyLevel.BEGINNER;

        System.out.println("Enter Difficulty Level: ");

        while(sc.hasNext()) {
            String inputString = sc.nextLine();
            try {
                difficultyLevel = DifficultyLevel.valueOf(inputString);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Difficulty Level passed");
                System.out.println("Please pass a valid input");
            }
        }

        return difficultyLevel;
    }
}
