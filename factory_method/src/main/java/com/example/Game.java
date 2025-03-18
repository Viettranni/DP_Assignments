package com.example;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose map type: 1 = CityMap, 2 = WildernessMap");
        int choice = scanner.nextInt();

        Map map;

        if (choice == 1) {
            System.out.println("You chose the CityMap! Please enter the Height: ");
            int height = scanner.nextInt();
            System.out.println("Please also enter the Width");
            int width = scanner.nextInt();
            
            map = new CityMap(height, width);
        } else {
            System.out.println("You chose the WildernessMap! Please enter the Height: ");
            int height = scanner.nextInt();
            System.out.println("Please also enter the Width");
            int width = scanner.nextInt();

            map = new WildernessMap(height, width);
        }

        map.display();

        scanner.close();
    }
}
