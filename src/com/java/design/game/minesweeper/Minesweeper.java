package com.java.design.game.minesweeper;

import com.java.design.game.minesweeper.model.Board;
import com.java.design.game.minesweeper.model.DifficultyLevel;
import com.java.design.game.minesweeper.model.MineSweeperPlayer;

import java.util.HashSet;
import java.util.Set;

public class Minesweeper {
    private final Set<MineSweeperPlayer> mineSweeperPlayers;
    private final Board board;
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public Minesweeper(DifficultyLevel level) {
        this.mineSweeperPlayers = new HashSet<>();
        this.board = new Board(level);
    }

    public void playGame(MineSweeperPlayer mineSweeperPlayer) {

    }

    public Board getBoard() {
        return this.board;
    }

    public char[][] click(final char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;

        Board.printBoard();

        if(m == 0 || n == 0) {
            System.out.println("Invalid Board");
        }

        if(!isValidBoundary(board, x, y)) return board;

        // If curr position on the board is a mine(M) then game is over(X)
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }

        // Else do recursively go to each point until the game is finished
        completeGame(board, x, y);

        // When no more squares are left to be revealed, the game is finished
        return board;
    }

    private void completeGame(final char[][] board, int x, int y){
        if(!isValidBoundary(board, x, y) || board[x][y] != 'E') return;

        // Get the number of mines from this point on the board
        int mines = getMines(board, x, y);

        // If a mine is closer from the curr position then add the character digit of how many mines are adjacent to the mine from this position
        if(mines != 0) board[x][y] = (char)('0' + mines);
        else {
            // Else change it to revealed Blank(B) and do dfs in each direction from this curr position
            board[x][y] = 'B';
            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];

                completeGame(board, newX, newY);
            }
        }
    }

    private int getMines(final char[][] board, int x, int y){
        int mines = 0;

        // Go in each direction from the curr position on the board
        // Check if it is a valid move
        // Whenever you come across a mine, increment the mines count
        for(int[] dir : directions){
            int newX = x + dir[0];
            int newY = y + dir[1];

            if(!isValidBoundary(board, newX, newY)) continue;
            if(board[newX][newY] == 'M') mines++;
        }

        return mines;
    }

    private boolean isValidBoundary(final char[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        return true;
    }

    public void registerPlayer(MineSweeperPlayer mineSweeperPlayer) {
        if(!isPlayerRegistered(mineSweeperPlayer)) {
            mineSweeperPlayers.add(mineSweeperPlayer);
        } else {
            System.out.println("Player Name already exists. Please try a different name. ");
        }
    }

    private boolean isPlayerRegistered(MineSweeperPlayer mineSweeperPlayer) {
        if(mineSweeperPlayers.contains(mineSweeperPlayer)) return false;
        return true;
    }
}
