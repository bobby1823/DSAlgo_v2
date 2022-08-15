package io.ghost.datastructure;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find the median of number of stream at any given point of time.
 */
public class Median_N_Stream_GivenTime {

    public static void main(String[] args) {
        int[] arr = {3,1,5};
        System.out.println("Median of Stream: "+ median(arr, arr.length));
    }

    public static int median(int[] arr, int n) {
        int j = n/2;
        // Max Heap Implementation for left PQ
        PriorityQueue<Integer> pQLeft = new PriorityQueue<>(Collections.reverseOrder());
        // Min Heap Implementation for Right PQ
        PriorityQueue<Integer> pQRight = new PriorityQueue<>();
        if (n%2==0) {
            for (int i = 0; i < n/2; i++) {
                pQLeft.add(arr[i]);
                pQRight.add(arr[j]);
                j=j+1;
            }
            return (pQLeft.poll() + pQRight.poll())/2;
        }
        for (int i = 0; i <= n/2; i++) {
            pQLeft.add(arr[i]);
        }
        return pQLeft.poll();
    }
}
