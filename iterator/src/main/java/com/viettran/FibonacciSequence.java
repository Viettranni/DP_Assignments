package com.viettran;

import java.util.Iterator;

// Storing the state here only makes sense if we want to share the progress or the app has only one user.

public class FibonacciSequence implements Sequence {
    private final int n;
    public FibonacciSequence(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }


    public int generateFibonacci(int current) {
        if (current <= 2) {
            return 1;
        }
        int a = 1, b = 1;
        int result = 0;
        for (int i = 3; i <= current; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

    // Passing the current FibonacciSequence into the parameters
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }
}