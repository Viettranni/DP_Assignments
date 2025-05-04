package com.viettran;

import java.util.Iterator;

// Storing the state here only makes sense if we want to share the progress or the app has only one user.

public class FibonacciSequence implements Iterable<Integer>, Sequence {
    private int count;

    public FibonacciSequence(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(count);
    }
    
}
