package com.viettran;

public class BubbleSort implements SortStrategy {

    // This code was taken and slighty modified from https://www.geeksforgeeks.org/bubble-sort-algorithm/?utm_source=geeksforgeeks&utm_medium=gfgcontent_shm&utm_campaign=shm
    // Bad performance once the dataset gets larger
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
