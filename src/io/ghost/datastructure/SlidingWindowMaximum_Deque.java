package io.ghost.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Find maximum element in the sliding window, as u slide the window through entire array
 *
 * Solution: Insert of Brute force which will result in O(n*k) complexity and space O(1)
 *           We will use Deque. Here Time complexity will be ~O(n) and space will be O(k)
 *           Here we will keep only the maximum number in the left most side of window And remove the
 *           useless elements.
 *           How to find UseLess elements:
 *                      ------> {4,1,3,5,1,2,3,2,1,1,5}
 *                      Initial Window in Deque: {4,1,3} when we try to put each in Deque we check that if the last element
 *                                                is smaller than the current element, if yes then replace the last element
 *                                                in Deque with current element.
 *
 *                                                U need to pop the last element from left when Deque length is full.
 *
 */
public class SlidingWindowMaximum_Deque {

    public static void main(String[] args) {
        int[] arr = {4,1,3,5,1,2,3,2,1,1,5};
        System.out.println("Element Largest in sliding window....");
        printMaxInSlidingWindow(arr, 3);
    }

    private static void printMaxInSlidingWindow(int[] arr, int k) {
        Deque<Integer> window = new ArrayDeque();
        // Processing first k elements
        int i;
        for (i = 0; i < k; i++) {
            if (!window.isEmpty() && arr[i] > arr[window.peekLast()]) {
                window.removeLast();
            }
            // Adding new element at the rear of the Queue. And we are storing the index of Queue.
            window.addLast(i);
        }

        // processing the rest of the queue.
        // 3
        for (; i < arr.length; ++i) {
            System.out.println(arr[window.peek()]);

            while (!window.isEmpty() && window.peek() <= i-k)
                window.removeFirst();
            // Removing the useless element.
            while (!window.isEmpty() && arr[i] >= arr[window.peekLast()]) {
                window.removeLast();
            }

            // Adding the element in last
            window.addLast(i);
        }
        System.out.println(arr[window.peek()]);
    }

}
