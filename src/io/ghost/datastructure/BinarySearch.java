package io.ghost.datastructure;

/**
 * Time Complexity: O(log(n))
 *      // Recursive way: Both Space and time complexity is O(log(n)
 *     // Iterative is better than that of Recursion, Since in Iterative Time Complexity is O(log(n)) and
 *     // constant Space complexity
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {-4, -1, 3, 7, 10, 11};
//        System.out.println("Number found in index " + findIndexBinarySearch(a, 7));
        System.out.println("Number found in index " + findIndexBinarySearchRecursion(a, 7, 0, a.length-1));
    }


    // Recursive way: Both Space and time complexity is O(log(n)
    // Iterative is better than that of Recursion, Since in Iterative Time Complexity is O(log(n)) and
    // constant Space complexity
    private static int findIndexBinarySearchRecursion(int[] a, int data, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high)/2;
        if (a[mid] == data) return mid;
        if (a[mid] > data) return findIndexBinarySearchRecursion(a, data, low, high-1);
        else return findIndexBinarySearchRecursion(a, data, mid+1, high);
    }

    // Iterative Way
    // -4, -1, 3, 7, 10, 11
    private static int findIndexBinarySearch(int[] a, int data) {
        int mid = -1;
        int low = 0;
        int high = a.length-1;
        if (a.length == 0)
            return -1;
        while (low <= high) {
            mid = (low + high)/2;
            if (a[mid] == data) {
                return mid;
            } else if (a[mid] > data) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
