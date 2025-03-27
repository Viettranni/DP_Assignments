package com.viettran;

public class Character {
    private String name;
    private CharacterLevelState level;
    private int experience_points;
    private int health_points;

    public Character(String name) {
        this.name = name;
        this.level = new NoviceState();
        this.experience_points = 0;
        this.health_points = 0;
    }

    public void train() {
        level.train(this);
    }
    
    public void mediate() {
        level.mediate(this);
    }
    
    public void fight() {
        level.fight(this);
    }

    // Leveling up according to the amount of experience points
    public void levelUp() {
        if (experience_points >= 150) {
            System.out.println("You have reached the maximum level of Master, thank you for participating!");
            System.out.println("Game ends.");
            this.level = new MasterState();
        } else if (experience_points >= 60) {
            System.out.println("Leveling up to Expert!");
            this.level = new ExpertState();
        } else if (experience_points >= 15) {
            System.out.println("Leveling up to Intermediate!");
            this.level = new IntermediateState();
        } else {
            System.out.println("You are not able to level up yet, keep gaining experience!");
        }
    }
    

    // Displaying the status of the Character
    public void displayCharacterStatus() {
        System.out.println("\n--- Character Status ---");
        System.out.println("Name: " + this.name);
        System.out.println("Level: " + getCurrentLevel());
        System.out.println("Experience Points: " + experience_points);
        System.out.println("Health Points: " + health_points);
        System.out.println("-------------------------");
    }
    

    public void addExperiencePoints(int points) {experience_points += points;};

    public void addHealthPoints(int points) {health_points += points;};

    public void decreaseExperiencePoints(int points) {experience_points -= points;};

    public void decreaseHealthPoints(int points) {health_points -= points;};

    public int getExperiencePoint() {
        System.out.println("You've got " + experience_points + " experience points!");
        return experience_points;
    };

    public int getHealthPoint() {return health_points;};

    public String getCurrentLevel() {return level.getName();};

    public String getName() {
        return name;
    }

    public void getAvailableActions() {
        level.getAvailableActions();
    }
}
