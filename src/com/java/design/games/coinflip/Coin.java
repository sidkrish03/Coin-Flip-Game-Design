package com.java.design.games.coinflip;

public class Coin {
    private String coinOption = "";
    public String[] coinValue = {"Heads", "Tails"};

    Coin() {
        // Random value of 0 or 1 is calculated
        int randNum = (Math.random() < 0.5) ? 0 : 1;
        coinOption = coinValue[randNum];
    }

    public String getCoinOption() {
        return coinOption;
    }
}
