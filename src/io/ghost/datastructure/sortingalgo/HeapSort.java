package io.ghost.datastructure.sortingalgo;

import io.ghost.datastructure.Heap;

import java.util.Stack;

public class HeapSort {

    public static void heapSort(int[] arr, int n) {
        // First construct the heap. Complexity O(n)
        Heap.createMaxHeap(arr, n);
        // Now deleting the Top element pushing it into Stack. And replacing last element to top
        for (int i = n; i > 1; i--) {
            // Swap
            int temp = arr[1]; // top element
            arr[1] = arr[i]; //
            arr[i] = temp; // n-i = last element

            // Now call heapify on top to second last element
            // Each call brings the largest element in top of array. then again swap method is called
            // Below n = i-1 because we want to call from top to -1 each time. Since in each call largest element is pushed to last
            Heap.heapify(arr, i-1, 1);
        }
    }
}
