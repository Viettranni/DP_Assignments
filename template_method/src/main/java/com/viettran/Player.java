package com.viettran;

public class Player {

    private int playerNumber;
    private int card;
    
    public Player(int playerNumber, int card) {
        this.playerNumber = playerNumber;
        this.card = card;
    }

    public int getCard() {
        return card;
    }

    public int getPlayerNumer(){
        return playerNumber;
    }
}
