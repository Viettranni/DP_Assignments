package com.viettran;

public class Main {
    public static void main(String[] args) {
        int numberOfFibs = 10; 

        Sequence fibSeq = new FibonacciSequence(numberOfFibs);

        for (int num : fibSeq) {  
            System.out.println(num);
        }
    }
}
