package io.ghost.datastructure.graph;

import java.lang.reflect.Array;
import java.util.*;

public class TopolocalBFS_KahnAlgo {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    }

    // By creating one extra array, inDegree which stores each in Degree of each element.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] inDegree = new int[V];
        boolean[] visited = new boolean [V];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inDegree[adj.get(i).get(j)] += 1;
            }
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(adj, V, inDegree, visited, ans);
            }
        }
        int[] ans1 = new int[V];
        for (int i = 0; i < V; i++) {
            ans1[i] = ans.get(i);
        }
        return ans1;
    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int v, int[] inDegree, boolean[] visited, ArrayList<Integer> ans) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                // putting the Indegree 0 in the queue.
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            ans.add(cur);
            for (Integer in : adj.get(cur)) {
                // Decreasing Degree
                inDegree[in] -= 1;
                if (inDegree[in] == 0) {
                    queue.add(in);
                }
            }
        }
    }
}
