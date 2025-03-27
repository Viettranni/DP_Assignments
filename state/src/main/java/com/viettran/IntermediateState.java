package com.viettran;

public class IntermediateState implements CharacterLevelState {
    private String name = "Intermediate";

    public String getName() {
        return name;
    }

    public void train(Character context) {
        System.out.println("Let's train! You've received 10 experience points");
        context.addExperiencePoints(10);
    }

    public void mediate(Character context) {
        System.out.println("Let's mediate, you've received 5 health points");
        context.addHealthPoints(5);
    }

    public void fight(Character context) {
        System.out.println("You're not currently able to fight, keep training!");
    }

    public void getAvailableActions() {
        System.out.print("Choose an action (train/mediate/exit): ");
    }

}
