package io.ghost.datastructure;

// heap insertion/deletion
public class Heap {

    public static void insertionMaxheap(int[] arr, int value) {
        // we are incrementing length + 1 because we are assuming zero index has nothing.
        int n = arr.length + 1;
        // putting the value in the end position of array.
        arr[n] = value;
        int i = n;
        while (i > 1) {
            // comparing element with its parent
            if (arr[i] < arr[i/2]) {
                // swap element with parent
                int temp = arr[i/2];
                arr[i/2] = arr[i];
                arr[i] = temp;
                i = i/2;
            } else
                return;
        }
    }

    // We delete the root node in heap. then we try replace the last node with root node position.
    // And we then start with first element and compare with each children
    public static void deleteMaxHeap(int[] arr, int n) {
        // deleting the root node by replacing with last element
        arr[1] = arr[n];
        n = n - 1;
        int i = 1;

        while (i < n) {
            // Need to handle the conditions like if left/right element present of not
            int left = arr[2*i] == 0 ? 0 : arr[i];
            int right = arr[2*i+1] == 0 ? 0 : arr[i+1];
            int larger;
            if (right != 0 && left < right) {
                larger = right;
                if (arr[i] < larger) {
                    int temp = arr[i];
                    arr[i] = arr[2*i+1];
                    arr[2*i+1] = temp;
                    i = 2*i+1;
                } else
                    return;
            } else {
                larger = left;
                if (arr[i] < larger) {
                    int temp = arr[i];
                    arr[i] = arr[2*i];
                    arr[2*i] = temp;
                    i = 2*i;
                } else
                    return;
            }
        }

    }

    // Creation of Heap from array.
    // Complexity is O(n) Optimised
    public static void createMaxHeap(int[] arr, int n) {
        // Here we are starting from i =n/2 because we do not to heapify leaf nodes. we are starting from bottom
        // NON-LEAF nodes
        for (int i = n/2; i < 1; i--) {
            heapify(arr, n, i);
        }
    }

    // This method makes the array in heap from a particular index
    public static void heapify(int [] arr, int n, int index) {
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
        int largestIndex = index;

        if (leftIndex <= n && arr[leftIndex] > arr[largestIndex]) {
            largestIndex = leftIndex;
        }
        if (rightIndex <= n && arr[rightIndex] > arr[largestIndex]) {
            largestIndex = rightIndex;
        }
        // now we check if current parent is the largest and then swap the parent with largest child
        // and recursively call heapify() for further down.
        if (largestIndex != index) {
            // Swap
            int temp = arr[largestIndex];
            arr[index] = arr[largestIndex];
            arr[largestIndex] = temp;
            // recursive call
            heapify(arr, n, largestIndex);
        }

    }
}
