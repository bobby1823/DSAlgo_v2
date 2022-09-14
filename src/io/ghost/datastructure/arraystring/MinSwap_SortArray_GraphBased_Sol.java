package io.ghost.datastructure.arraystring;

import java.util.Arrays;

public class MinSwap_SortArray_GraphBased_Sol {

    public static void main (String[] args) {
        int[] nums = new int[]{10, 19, 6, 3, 5};
        System.out.println(minSwaps(nums));
    }

    /**
     * 1. Create an auxArr with elements as Swap. Meaning Swap object will contain the num[i] and i
     * 2. Sort the auxArr based on num[i]
     * 3.
     *
     */
    public static int minSwaps(int nums[]) {
        int countSwap = 0;
        int len = nums.length;
        Swap[] auxArr = new Swap[len];
        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            visited[i] = false;
            Swap swap = new Swap(nums[i], i);
            auxArr[i] = swap;
        }
        // Sorting the Auxiliary Array
        Arrays.sort(auxArr);


        // Main Operation
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            if (auxArr[i].i == nums[i]) {
                visited[auxArr[i].index] = true;
                continue;
            }
            int count = 0;
            int j = i;
            while(!visited[j]) {
                visited[j] = true;
                j = auxArr[j].index;
                count += 1;
            }
            countSwap += count - 1;
        }

        return countSwap;
    }
}

class Swap implements Comparable<Swap> {
    int i;
    int index;

    Swap(int i, int index) {
        this.i = i;this.index = index;
    }

    @Override
    public int compareTo (Swap o) {
        return this.i - o.i;
    }
}
