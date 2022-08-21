package io.ghost.datastructure.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 */
public class LongestSubArr_Ones_Replacement {

    public static void main(String[] args) {
        System.out.println("Count: " + find(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
    }

    // [0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
    public static int find(int[] arr, int k) {
        int windowStart = 0, windowEnd = 0, maxWinLength = 0, maxOneCount = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            windowEnd = i;
            maxOneCount = map.getOrDefault(1, 0);

            while (((windowEnd - windowStart + 1) - maxOneCount) > k) {
                if (map.get(arr[windowStart]) > 1) {
                    map.put(arr[windowStart], map.get(arr[windowStart]) - 1);
                } else {
                    map.remove(arr[windowStart]);
                }
                windowStart += 1;
            }
            if (((windowEnd - windowStart + 1) - map.getOrDefault(1, 0)) <= k) {
                maxWinLength = Math.max(maxWinLength, (windowEnd - windowStart + 1));
            }
        }
        return maxWinLength;
    }
}
