package io.ghost.datastructure.arraystring;

import java.util.*;

public class Top_K_Frequent_Elements {

    public static void main(String[] args) {
        System.out.println(topKFrequent_Optimised(new int[]{1, 1, 1, 2, 2, 2, 3}, 2)[0]);
    }

    /**
     *
     * this solution provides the Time Complexity in O(n) and Space Complexity in O(n)
     * by using Bucket sorting Algo . So here instead of using PriorityQueue (which uses Heapify). We will maintain
     * an auxiliary array where index will be number of occurrence of each element. Meaning if one is present 5 times then
     * Example: a[5] = 1.
     * So maximum size of aux array will be n + 1, where n = size of input array
     */
    public static int[] topKFrequent_Optimised(int[] nums, int k) {
        int[] arr = new int[k];
        List<Integer>[] auxArr = new ArrayList[nums.length + 1];
        for (List<Integer> in : auxArr) {
            in = null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer in : nums) {
            if (map.containsKey(in)) {
                map.put(in, map.getOrDefault(in, 1) + 1);
            } else {
                map.put(in, 1);
            }
        }

        // Iterating in the Map and storing the value - key pair as auxArr[value] = key
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> l;
            if (auxArr[entry.getValue()] != null) {
                l = auxArr[entry.getValue()];
            } else {
                l = new ArrayList<>();
            }
            l.add(entry.getKey());
            auxArr[entry.getValue()] = l;

        }
        for (int i = 0; i < k; ) {
            for (int j = auxArr.length-1; j >= 1; j--) {
                if (auxArr[j] != null) {
                    for (Integer in : auxArr[j]) {
                        arr[i] = in;
                        i += 1;
                    }
                } else {
                    i = i + (auxArr[j] == null ? 0 : auxArr[j].size());
                }
                if (i >= k) {
                    break;
                }
            }
        }

        return arr;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        PriorityQueue<Element> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer in : nums) {
            if (map.containsKey(in)) {
                map.put(in, map.getOrDefault(in, 1) + 1);
            } else {
                map.put(in, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Element(entry.getKey(), entry.getValue()));
        }
        for (int i = 0; i < k; i++) {
            arr[i] = queue.poll().el;
        }
        return arr;
    }
}


class Element implements Comparable<Element> {
    int el;
    int count;

    Element(int el, int count) {
        this.el = el;
        this.count = count;
    }

    @Override
    public int compareTo(Element o) {
        return -(this.count - o.count);
    }
}









