package com.viettranni;

public class WeatherObserver {
    String name;

    // Constructor
    public WeatherObserver(String name) {
        this.name = name;
    }

    public void notifyObserver(int tempeture) {
        System.out.println("Hello " + name + ", the new Tempeture: " + tempeture);
    }
}
