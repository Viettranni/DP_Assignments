package com.viettranni;


public class Main {
    public static void main(String[] args) {

        // Creating the Weather Station
        WeatherStation weatherStation = new WeatherStation();

        // Creating the Observers
        WeatherObserver viet = new WeatherObserver("Viet");
        WeatherObserver saed = new WeatherObserver("Saed");
        WeatherObserver pavel = new WeatherObserver("Pavel");
        WeatherObserver ivan = new WeatherObserver("Ivan");

        // Adding the initial Observers into the stations subscribtion
        weatherStation.registerObserver(viet);
        weatherStation.registerObserver(saed);
        weatherStation.registerObserver(pavel);
        
        // Running the Weather Station on it's own Thread
        Thread weatherThread = new Thread(weatherStation);
        weatherThread.start();

        // Delaying for 10 seconds for removing Viet from the subscribtion
        try {
            Thread.sleep(10000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        weatherStation.removeObserver(viet);
        System.out.println("Viet unsubscribed!");

        // Delaying for another 10 seconds for adding Ivan to the subscribtion
        try {
            Thread.sleep(10000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        weatherStation.registerObserver(ivan);
        System.out.println("Ivan subscribed!");
        
        // Giving the process more time
        try {
            Thread.sleep(30000); 
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
