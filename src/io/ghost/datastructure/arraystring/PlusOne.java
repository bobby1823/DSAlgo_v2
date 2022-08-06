package io.ghost.datastructure.arraystring;

public class PlusOne {

    public static void main(String[] args) {
        int [] arr = {5,6,2,0,0,4,6,2,4,9};
        System.out.println("New Array after adding one: "+ fetchArrayDigitsAddOne(arr));
    }

    // Approach-1 Brute Force
    // 49999
    private static int[] fetchArrayDigitsAddOne(int[] digits) {
        int[] newArr = null;
        int len = digits.length;

        int carry = 0;

        for (int i = len-1; i >= 0 ; i--) {
            if ((digits[i] + 1) > 9) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        if (carry == 1) {
            newArr = new int[digits.length+1];
            newArr[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newArr[i+1] = digits[i];
            }

        }
        return newArr;
    }
}
