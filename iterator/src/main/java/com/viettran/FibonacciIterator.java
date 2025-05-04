package com.viettran;

import java.util.Iterator;

// The state of the Fibonacci calculation is implemented and stored here. 
// Keeping the state here ensures that multiple iterations form the same sequence is independent of each other.

public class FibonacciIterator implements Iterator<Integer> {
    private int count;
    private int currentIndex = 1;
    private int prev = 0;
    private int curr = 1;

    public FibonacciIterator(int count) {
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < count;
    }

    @Override
    public Integer next() {
        currentIndex++;

        if (currentIndex == 1 ) {
            return 1;
        }

        int next = prev + curr;
        prev = curr;
        curr = next;
        return prev;
    }
}
