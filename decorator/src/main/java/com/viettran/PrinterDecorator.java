package com.viettran;

public class PrinterDecorator implements Printer {
    protected Printer decoraredPrinter;

    public PrinterDecorator(Printer printer) {
        this.decoraredPrinter = printer;
    }

    public void print(String message) {
        decoraredPrinter.print(message);
    }
}
