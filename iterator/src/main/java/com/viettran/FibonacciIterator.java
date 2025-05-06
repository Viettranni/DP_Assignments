package com.viettran;

import java.util.Iterator;

// The state of the Fibonacci calculation is implemented and stored here. 
// Keeping the state here ensures that multiple iterations form the same sequence is independent of each other.

public class FibonacciIterator implements Iterator<Integer> {
    private final FibonacciSequence sq;
    private int current;

    public FibonacciIterator(FibonacciSequence sq) {
        this.sq = sq;
        current = 1;
    }

    @Override
    public boolean hasNext() {
        return current <= sq.getN();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int result = sq.generateFibonacci(current);
            current++;
            return result;
        }
        return null;
    }
}
