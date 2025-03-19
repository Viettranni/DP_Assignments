package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boolean isTrue = false;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please select Style: A/B");
        String character = scanner.nextLine();

        UIFactory factory = null;

        // Checking if it is A or B
        if (character.equals("A")) {
            factory = new FactoryA();
        } else if (character.equals("B")) {
            factory = new FactoryA();
        } else {
            System.out.println("You failed to provide the available style!");
        }

        // Asking the user to input the texts to Elements
        System.out.println("Please input text for Button: ");
        String buttonText = scanner.nextLine();

        System.out.println("Please input text for TextField: ");
        String textForTextField = scanner.nextLine();

        System.out.println("Please input text for CheckBox");
        String textCheckBox = scanner.nextLine();

        System.out.println("Would you like to check the box also? true/false");
        String userInput = scanner.nextLine();

        isTrue = Boolean.parseBoolean(userInput);


        // Creating Elements
        Button fancyButton = factory.createButton(buttonText);
        fancyButton.display();

        TextField fancyTextField = factory.createTextField(textForTextField);
        fancyTextField.display();

        CheckBox fancyCheckBox = factory.createCheckBox(textCheckBox, isTrue);
        fancyCheckBox.display();

        scanner.close();
    }
}
