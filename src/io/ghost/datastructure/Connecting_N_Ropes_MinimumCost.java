package io.ghost.datastructure;

import java.util.PriorityQueue;

public class Connecting_N_Ropes_MinimumCost {

    public static void main(String[] args) {
//        int[] arr = {2, 5, 4, 8, 6, 9 };
        int[] arr = { 4,3,2,6 };
        System.out.println("Minimum cost to connect all the Ropes: "+connectMinimumCost(arr));
    }
    public static int connectMinimumCost(int[] arr) {
        int cost = 0;
        // Minimum heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // Adding all the elements in Priority Queue
        for (Integer in : arr)
            priorityQueue.add(in);
        while (priorityQueue.size() != 1) {
            int el1 = priorityQueue.poll();
            int el2 = priorityQueue.poll();
            cost += el1 + el2;
            priorityQueue.add(el1+el2);
        }
        return cost;
    }
}
