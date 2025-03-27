package com.viettran;

public class MasterState implements CharacterLevelState {
    private String name = "Master";

    public String getName() {
        return name;
    }

    public void train(Character context) {
        System.out.println("You have reached the maximum level, the game ends!");
    }

    public void mediate(Character context) {
        System.out.println("You have reached the maximum level, the game ends!");
    }

    public void fight(Character context) {
        System.out.println("You have reached the maximum level, the game ends!");
    }

    public void getAvailableActions(){};
}
