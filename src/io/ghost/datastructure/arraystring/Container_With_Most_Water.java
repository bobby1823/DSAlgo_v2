package io.ghost.datastructure.arraystring;

public class Container_With_Most_Water {
    public static void main(String[] args) {
        System.out.println("Water amount: "+ maxArea(new int[]{1,2,1}));
    }

    // Two Pointer approach.
    public static int maxArea(int[] height) {
        int max = 0;
        int leftPointer = 0, rightPointer = height.length-1;
        while (leftPointer < rightPointer) {
            if (height[leftPointer] < height[rightPointer]) {
                max = Integer.max(max, height[leftPointer]* (rightPointer-leftPointer));
                leftPointer += 1;
            } else {
                max = Integer.max(max, height[rightPointer]* (rightPointer-leftPointer));
                rightPointer -= 1;
            }
        }
        return max;
    }
}
