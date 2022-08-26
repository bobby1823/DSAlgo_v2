package io.ghost.datastructure.graph;

import java.util.*;

/**
 * Minimum Shortest distance from source to destination
 */
public class BFS_Graph {

    /**
     * In Breadth First search we use Level order traversal logic
     * @param args
     */
    public static void main(String[] args) {

    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> in = new ArrayList<>();
        int[] parent = new int[V];
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            parent[i] = -1;
            distance[i] = 0;
        }
        distance[0] = 0;
        visited[0] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            in.add(curr);

            for (Integer neighbour : adj.get(curr)) {
                if (!visited[neighbour]) {
                    q.add(neighbour);
                    // marking visited
                    visited[curr] = true;
                    // tracking the parent as well and distance from parent.
                    parent[neighbour] = curr;
                    // child's distance will be from parent will be parent's distance + 1;
                    distance[neighbour] = distance[curr] + 1;
                }
            }
        }
//        for (int i = 0; i < parent.length; i++) {
//            in.add(parent[i]);
//        }
        return in;
    }
}
