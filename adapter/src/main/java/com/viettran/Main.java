package com.viettran;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();
        
        date.setYear(2023);
        date.setMonth(1); 
        date.setDay(1);

        System.out.println("Original date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(5);

        System.out.println("New date after 5 days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}
