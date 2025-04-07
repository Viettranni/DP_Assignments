package com.viettran;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SorterContext context = new SorterContext();

        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100_000);

        testStrategy(context, new BubbleSort(), smallArray.clone(), "Bubble Sort - Small");
        testStrategy(context, new QuickSort(), smallArray.clone(), "Quick Sort - Small");
        testStrategy(context, new MergeSort(), smallArray.clone(), "Merge Sort - Small");

        testStrategy(context, new BubbleSort(), largeArray.clone(), "Bubble Sort - Large"); 
        testStrategy(context, new QuickSort(), largeArray.clone(), "Quick Sort - Large");
        testStrategy(context, new MergeSort(), largeArray.clone(), "Merge Sort - Large");
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(1000);
        return arr;
    }

    public static void testStrategy(SorterContext context, SortStrategy strategy, int[] data, String label) {
        context.setStrategy(strategy);
        long start = System.nanoTime();
        context.executeSort(data);
        long end = System.nanoTime();
        System.out.println(label + " took " + ((end - start) / 1_000_000.0) + " ms");
    }
}
