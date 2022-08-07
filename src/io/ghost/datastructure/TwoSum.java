package io.ghost.datastructure;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] array = { 10,15,-5,15,-10,5};
        int[] returnedArray = rotate(array, 5);
        Arrays.stream(returnedArray).forEach(s -> {System.out.println("Index "+s);});
    }

    public static int[] rotate(int[] nums, int k) {
        int[] sol = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        // Optimal Solution

//        for (int i=0;i<nums.length;i++) {
//            Integer requiredNum = (Integer) k-nums[i];
//            if (map.containsKey(requiredNum)) {
//                sol[0] = i; sol[1]=map.get(requiredNum);
//                return sol;
//            }
//            map.put(nums[i],i);
//        }
        // Brute force method
//        int sum = 0;
//        for (int i = 0; i < nums.length-1; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                System.out.println(i +" "+ j);
//                sum = 0;
//                for (int l = i; l <= j; l++) {
//                    System.out.println(l);
//                    sum +=l;
//                    if(sum == k) {
//                        sol[i] = i;sol[j]=j;
//                        return sol;
//                    }
//                }
//
//            }
//        }
        // Approach 2
        int start = 0;
        int curSum = 0;
        int end = -1;
//        10,15,-5,15,-10,5
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (map.containsKey(curSum - k)) {
                start = map.get(curSum-k)+1;
                end = i;
                sol[0] = start; sol[1] = end;
            }

            map.put(curSum,i);
        }

//        System.out.println(sol[0] +" "+ sol[1]);
        return sol;
    }
}
