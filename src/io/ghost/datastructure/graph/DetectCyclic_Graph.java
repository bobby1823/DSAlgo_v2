package io.ghost.datastructure.graph;

import java.util.ArrayList;

public class DetectCyclic_Graph {

    public static boolean isGraphCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        // Default value of parent.
        int prev = -1;
        // Check for non connected Sub Graph
        for (int i = 0; i < adj.size(); i++) {
            if (!isVisited[i]) {
                if (checkGraphCyclic(i, isVisited, adj, -1)) return true;
            }
        }
        return false;
    }

    // Here we are passing the information of parent as well. Since to check for cyclic we need to avoid that check where we are
    // traversing from parent to child, but we can traverse from child to parent as well. So,
    private static boolean checkGraphCyclic(int v, boolean[] isVisited,
                                            ArrayList<ArrayList<Integer>> adjacentList,
                                            int prev) {
        isVisited[v] = true;

        for (Integer in : adjacentList.get(v)) {
            if (!isVisited[in] ) {
                if (checkGraphCyclic(in, isVisited, adjacentList, v)){
                    return true;
                }
            } else if (prev != in) {
                return true;
            }
        }
        return false;
    }
}
