package io.ghost.datastructure.arraystring;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println("Rain Water trapped: " + trapWaterDynamicProb(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    // Here we use two auxiliary array, left & right, which stores:
    // at any given index, left array stores largest element from left side of that index, and right array stores the
    // largest element from right side of that index.
    // Because to trap rain water, at any given index we need to know largest left and largest right from that index
    public static int trapWaterDynamicProb(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        right[arr.length-1] = arr[arr.length-1];
        int totalWater = 0;
        for (int i = 1; i <= arr.length-1; i++) {
            if (left[i-1] < arr[i]) {
                left[i] = arr[i];
            } else {
                left[i] = left[i-1];
            }
        }
        for (int i = arr.length-1; i > 0; i--) {
            if (right[i] < arr[i-1]) {
                right[i-1] = arr[i-1];
            } else {
                right[i-1] = right[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            totalWater += Integer.min(left[i], right[i])-arr[i];
        }
        return totalWater;
    }

    // Here in the stack we will be pushing the index
//    public static int trapWaterUsingStack(int[] arr) {
//        Stack<Integer> stk = new Stack<>();
//        stk.push(0);
//        for (int i = 1; i < arr.length; i++) {
//            while (!stk.isEmpty() && arr[i] > stk.peek()) {
//
//            }
//            stk.push(i);
//        }
//    }
}
