package io.ghost.datastructure.graph;

import java.util.ArrayList;

public class DetectCyclic_Graph_2 {

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        // storing parent
        int prev = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCyclic(i, adj, visited, -1)) return true;
            }
        }
        return false;
    }

    private static boolean dfsCyclic(int i, ArrayList<ArrayList<Integer>> adj,
                                     boolean[] visited, int prev) {
        visited[i] = true;

        // prev = i; do not do this mistake. If u are making prev as i then
        // u are making current as prev/parent
        for (Integer neighbour: adj.get(i)) {
            if (!visited[neighbour]) {
                // imp: here u are making current as parent/prev. And neighbour
                // as current for next dfs call.
                if (dfsCyclic(neighbour, adj, visited, i)) {
                    return true;
                }
            } else if (prev != neighbour) {
                return true;
            }
        }
        return false;
    }
}
