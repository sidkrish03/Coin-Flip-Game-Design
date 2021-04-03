package com.java.design.game.minesweeper.model;

import java.util.Arrays;

public class Board {
    private static char[][] board;
    private final DifficultyLevel level;

    public Board(DifficultyLevel level) {
        this.level = level;
        setupBoard();
    }

    private void setupBoard() {
        createBoard();
        for(char[] row : board) {
            Arrays.fill(row, 'E');
        }
    }

    private void createBoard() {
        if(level == DifficultyLevel.BEGINNER) {
            this.board = new char[8][8];
        } else if(level == DifficultyLevel.INTERMEDIATE) {
            this.board = new char[16][16];
        } else if(level == DifficultyLevel.ADVANCED) {
            this.board = new char[24][24];
        } else {
            this.board = new char[8][8];
        }
    }

    public static void printBoard() {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            System.out.print('[' + " ");
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(']');
        }
    }
}
