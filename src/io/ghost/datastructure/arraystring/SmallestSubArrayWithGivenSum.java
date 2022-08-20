package io.ghost.datastructure.arraystring;

/**
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0, if no such subarray exists.
 */
public class SmallestSubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println("Minimum Length of substring " +smallestSubArraySum(arr, 7));
    }

    public static int smallestSubArraySum(int[] arr, int s) {
        int minLen = Integer.MAX_VALUE;
        int windowStart = 0, windowEnd = 0, winSum = 0;

        for (int i = 0; i < arr.length; i++) {
            winSum += arr[i];
            windowEnd = i;

            while (winSum >= s) {
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
                winSum -= arr[windowStart];
                windowStart += 1;
            }

        }
        return minLen >= Integer.MAX_VALUE ? -1 : minLen;
    }
}
