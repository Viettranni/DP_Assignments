package com.viettran;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int numbers = 10;

        FibonacciSequence fibonacciSequence = new FibonacciSequence(numbers);
        Iterator<Integer> iterator = fibonacciSequence.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
