package io.ghost.datastructure.arraystring;

import java.util.HashSet;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class Product_Of_Array {
    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{-1,1,0,-3,3}));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] productArray = new int[nums.length];
        int temp = 1;

        for (int i = 0; i < n; i++) {
            productArray[i] = 1;
        }
        // For storing the prefix multiplication
        for (int i = 0; i < n; i++) {
            productArray[i] = temp;
            temp *= nums[i];
        }
        // Reinitialising temp
        temp = 1;
        // For storing the postfix multiplication
        for (int i = n-1; i >= 0; i--) {
            productArray[i] *= temp;
            temp *= nums[i];
        }

        return productArray;
    }
}
