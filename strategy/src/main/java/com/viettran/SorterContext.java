package com.viettran;

public class SorterContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] arr) {
        if (strategy != null) {
            strategy.sort(arr);
        } else {
            System.out.println("No sorting strategy set!");
        }
    }
}
