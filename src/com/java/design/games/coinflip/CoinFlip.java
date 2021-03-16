package com.java.design.games.coinflip;

public class CoinFlip {
    Player[] players = new Player[2];
    Coin chosenCoin = new Coin();
    CoinFlip(String player1Name, String player2Name) {
        players[0] = new Player(player1Name);
        players[1] = new Player(player2Name);
    }

    public void startGame() {
        // Pick a random player to choose the face value guess
        int randIndex = (Math.random() < 0.5) ? 0 : 1;
        String playersPick = players[randIndex].getRandCoinOption();

        // Set the opponents coinOption to the opposite value
        int opponentsIndex = (randIndex == 0) ? 1 : 0;
        players[opponentsIndex].setCoinOption(playersPick);

        // Flip the coin to find the winning face value
        String winningFlip = chosenCoin.getCoinOption();

        // See the results of the flip
        players[0].didPlayerWin(winningFlip);
        players[1].didPlayerWin(winningFlip);
    }
}

