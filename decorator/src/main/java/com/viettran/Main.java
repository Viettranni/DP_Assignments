package com.viettran;

public class Main {
    public static void main(String[] args) {

        // Initializing the base printer 
        Printer basicPrinter = new BasicPrinter();

        // Initializing and testing the Encrypted Printer which wraps the Basic Printer
        EncryptedPrinter encryptedPrinter = new EncryptedPrinter(basicPrinter);
        System.out.println("Printing encrypted message: ");
        encryptedPrinter.print("Hello Vieeet!");

        System.out.println();

        // Initializing and testing the XML Printer which wraps the Basic Printer
        XMLPrinter xmlPrinter = new XMLPrinter(basicPrinter);
        System.out.println("Printing XML wrapped message: ");
        xmlPrinter.print("This is XML Printer");

        System.out.println();
    
        // Wrapping the basic printer into two other wrappers
        EncryptedPrinter printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        System.out.println("Wrapping the printer into two other wrappers: ");
        printer2.print("Hello World! My name is Vieeet");
    }
}