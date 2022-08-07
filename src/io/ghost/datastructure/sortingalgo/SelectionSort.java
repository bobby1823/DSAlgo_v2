package io.ghost.datastructure.sortingalgo;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1,6,9,3,2,6};
        int [] arr1 = selectionSort(arr);
        Arrays.stream(arr1).forEach(s -> System.out.println(s));
    }

    // 4,6,9,3,2,6
    // 1,6,9,3,2,6
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length ; j++) {
                    if (arr[min] > arr[j]) {
                        min = j;
                    }
            }
            if (min != i) {
             int temp = arr[i];
             arr[i] = arr[min];
             arr[min] = temp;
            }
        }
        return arr;
    }
}
