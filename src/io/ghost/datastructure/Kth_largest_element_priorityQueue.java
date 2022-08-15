package io.ghost.datastructure;

import java.util.PriorityQueue;

public class Kth_largest_element_priorityQueue {

    public static int kthElement(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }

        // now we will compare each element from Kth position to n-1 with PriorityQueue.
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        return priorityQueue.peek();
    }
}
