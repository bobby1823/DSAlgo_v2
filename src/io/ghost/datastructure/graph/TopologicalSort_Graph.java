package io.ghost.datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;

// This topological sort in Graph means that the node (u) pointing to node (v) prints such that first u prints then v.
// This process is used where we want to execute/perform some action after completion of all child dependencies.
public class TopologicalSort_Graph {

    /**
     * V= vertices
     * adj= adjacency List
     *
     * Traversing this in DFS (Depth First Search)
     * @param V
     * @param adj
     * @return
     */
    public static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // defining array which got visited. Default is all false
        boolean[] visited = new boolean[V];
        // Defining stack. This stack is used to contain all the element in the order of their least dependency
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(V, adj, visited, stack);
            }
        }
        int[] arr = new int[V];
        for (int i = 0; i < V; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

    private static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        // making visited array true at index v
        visited[v] = true;

        // Getting the neighbouring elements from adjacency list
        for (Integer neighbour : adj.get(v)) {
            // chcking if neighbouring has been visited.
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, stack);
            }
        }
        stack.push(v);
    }
}
