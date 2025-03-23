package com.viettranni;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable{
    Random rand = new Random();
    List<WeatherObserver> observers = new ArrayList<>();
    int currentTempeture = rand.nextInt(25);
    
    // Empty constructor
    public WeatherStation(){};

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void run() {
        while (true) {
            System.out.println("TEMPETURE UPDATE!!!!");
            int previousTempeture = currentTempeture;
            // Updating the tempeture
            currentTempeture += new Random().nextInt(3) - 1;

            // Making sure that the tempeture wont exceed the -15 and 32 Celcius
            if (currentTempeture <= -15) {
                currentTempeture = -15;
            } else if (currentTempeture >= 32) {
                currentTempeture = 32;
            }

            // Notifying the Observers
            if (currentTempeture != previousTempeture) {
                for (WeatherObserver observer:observers) {
                    observer.notifyObserver(currentTempeture);
                } 
            } else {
                System.out.println("The tempeture remains the same!");
            }

            // Delaying the program randomly by 5 seconds
            int randomDelay = rand.nextInt(5000);
            try {
                Thread.sleep(randomDelay);
                } 
            catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
        }
    }
}
