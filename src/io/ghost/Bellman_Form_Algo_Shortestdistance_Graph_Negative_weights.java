package io.ghost;

import java.util.Arrays;

/**
 * This is applicable when the weights in graph are negative.
 * Time Complexity: O((n-1)*e), where n is number of vertices and e is number of Edges
 */
public class Bellman_Form_Algo_Shortestdistance_Graph_Negative_weights {

    public static void main(String[] args) {

    }

    // Find if negative weights cycle present.
    // Meaning whether the cycle sum is negative
    // matrix of edges have been given. {{0,1,-1},{1,2,2},{0,3,8}}
    // the first two are the vertices and third one is weight
    public static boolean isNegativeWeight(int v, int[][] edges) {

        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        // Here we are taking random start value. In this case 0th vertex
        dis[0] = 0;
        for (int i = 1; i < v; i++) {
            for (int j = 0; j < edges.length; j++) {
                int src = edges[j][0];
                int des = edges[j][1];
                int wt = edges[j][2];
                // Note this additional check is important while handling Max value. Since Max Int value + weight will
                // become negative value.
                if (dis[src]!= Integer.MAX_VALUE && dis[src] + wt < dis[des]) {
                    dis[des] = dis[src] + wt;
                }
            }
        }

        for (int j = 0; j < edges.length; j++) {
            int src = edges[j][0];
            int des = edges[j][1];
            int wt = edges[j][2];
            // Note this additional check is important while handling Max value. Since Max Int value + weight will
            // become negative value.
            if (dis[src]!= Integer.MAX_VALUE && dis[src] + wt < dis[des]) {
                return true;
            }
        }
        return false;
    }
}
