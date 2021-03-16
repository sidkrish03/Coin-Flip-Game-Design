package com.java.design.games.coinflip;

public class Player {
    private String name = "";
    private String coinOption = "";

    public String[] coinValue = {"Heads", "Tails"};

    Player(String newName) {
        name = newName;
    }

    public String getCoinOption() {
        return coinOption;
    }

    // Set coinOption to the opposite of what is set for player 1
    public void setCoinOption(String opponentFlip) {
        coinOption = (opponentFlip == "Heads") ? "Tails" : "Heads";
    }

    public String getRandCoinOption() {
        // Get random option 0  or 1
        int randNum = (Math.random() < 0.5) ? 0 : 1;

        // Set value based on the chosen random value
        // for the array coinValue which will then choose either head or tails
        coinOption = coinValue[randNum];

        return coinValue[randNum];
    }

    // Decide the winner
    public void didPlayerWin(String winningFlip) {
        if(coinOption == winningFlip) {
            System.out.println(name + " won with a flip side of " + coinOption);
        } else {
            System.out.println(name + " lost with a flip side " + coinOption);
        }
    }
}
