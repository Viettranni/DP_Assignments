package com.viettran;

public class NoviceState implements CharacterLevelState {
    private String name = "Novice";

    public String getName() {
        System.out.println("You're currently on " + name + " level!");
        return name;
    }

    public void train(Character context) {
        System.out.println("Let's train! You've received 5 experience points");
        context.addExperiencePoints(5);
    }

    public void mediate(Character context) {
        System.out.println("You can't mediate yet, keep training to level up!");
    }

    public void fight(Character context) {
        System.out.println("You're not currently able to fight, keep training!");
    }

    public void getAvailableActions() {
        System.out.print("Choose an action (train/exit): ");
    }

}
