package com.viettranni;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Creating a Viet's file and writing to it
        logger.setFileName("Viet's_file.txt");
        logger.write("Hello my name is Viet.");
        logger.write("It is nice to meet you!");
        logger.close();

        // Creating a new file to write to
        logger.setFileName("Planning.txt");
        logger.write("Today I will go the gym.");
        logger.write("And also go for a lunch at the near cafeteria.");
        logger.close();
    }
}