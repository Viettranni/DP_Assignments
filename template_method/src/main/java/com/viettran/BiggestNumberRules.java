package com.viettran;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BiggestNumberRules extends Game {
    // You just need to create the logic for 4 methods defined in the Game Abstract class
    private List<Player> players = new ArrayList<>();
    private int leadingNumber;
    private Player leadingPlayer;
    private boolean gameEndStatus = false;

    @Override
    public void initializeGame(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            int randomCardNumber = (int)(Math.random() * 101);
            players.add(new Player(i, randomCardNumber));
        }
    }

    @Override
    public boolean endOfGame() {
        return gameEndStatus;
    }

    @Override
    public void playSingleTurn(int player) {
        for (Player gamer : players) {
            if (gamer.getPlayerNumer() == player) {
                if (gamer.getCard() > leadingNumber) {
                    System.out.println("We have a BIGGGER number! Will this secret player be the winner? Current largest number: " + leadingNumber);
                    leadingNumber = gamer.getCard();
                    leadingPlayer = gamer;
                    continue;
                } else if (gamer.getCard() == leadingNumber) {
                    System.out.println("We have a match! Nothing happens");
                } else {
                    System.out.println("The number is less than the leading number, this player is definitely not winnig, SKIP");
                }
                break;
            }
        }
        if (player >= players.size() - 1) {
            System.out.println("THE GAME ENDS");
            gameEndStatus = true;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Our winner is Player " + leadingPlayer.getPlayerNumer() + "!");
    }
}
