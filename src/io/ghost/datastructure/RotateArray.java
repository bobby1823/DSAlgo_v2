package io.ghost.datastructure;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = { 1,2,3,4,5,6,7};
        rotate(array, 3);
    }
//-100,3,99,-1
//3,99,-1,100

    public static void rotate(int[] nums, int k) {
        // Brute force method
        int size = nums.length;
        int[] copy = nums.clone();
        for (int i=0; i<size; i++) {
            nums[(i+k) % size] = copy[i];
        }

        for (int i=0; i<size; i++) {
            System.out.println(nums[i]);
        }
    }

}
