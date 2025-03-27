package com.viettran;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Create a character
        Character player = new Character("Viet");
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (true) {
            // Display current status
            player.displayCharacterStatus();
            
            // Get user's choice
            System.out.println("You can also try to level UP by up!");
            player.getAvailableActions();
            String action = scanner.nextLine().toLowerCase();

            // Process the action
            switch (action) {
                case "train":
                    player.train();
                    break;
                case "mediate":
                    player.mediate();
                    break;
                case "fight":
                    player.fight();
                    break;
                case "exit":
                    System.out.println("Exiting game.");
                    scanner.close();
                    return;
                case "up":
                    player.levelUp();
                    break;
                default:
                    System.out.println("Invalid action. Please choose again.");
            }
        }
    }
}