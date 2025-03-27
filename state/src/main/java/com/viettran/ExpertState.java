package com.viettran;

public class ExpertState implements CharacterLevelState{
    private String name = "Expert";

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
        if (context.getHealthPoint() < 5) {
            System.out.println("You don't have enough health to fight, keep mediating.");
        } else {
            System.out.println("You're now Expert, FIGHT FIGHT, you lost 5 health points and gained 20 experience points!");
            context.addExperiencePoints(15);
            context.decreaseHealthPoints(5);
        }
    }

    public void getAvailableActions() {
        System.out.print("Choose an action (train/mediate/fight/exit): ");
    }

}
