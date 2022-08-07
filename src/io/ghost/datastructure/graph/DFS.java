package io.ghost.datastructure.graph;

import java.util.ArrayList;

public class DFS {

    public static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adjacentList) {
        // Creating the Array of visited Node
        boolean [] visited = new boolean[v];
        ArrayList<Integer> data = new ArrayList<>();

        // This for loop is used to solve the cases where we have graph parts which are not connected as well
        // Starting from zero since in the loop we are getting number from zero
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                // v=0, we have randomly chosen starting position as 0 element. We could have chosen some other as well
                // If we had chosen some other element then our final array list sequence will be different.
                dfs(0, adjacentList, visited, data);
        }
        return data;
    }

    public static void dfs(int v, ArrayList<ArrayList<Integer>> adjacentList, boolean[] visited, ArrayList<Integer> data) {
        // making this visited Array to be true
        visited[v] = true;
        data.add(v);
        // Loop to iterate through the adjacent list to go through each node.
        for (Integer in : adjacentList.get(v)) {
            // Checks if its visited or not.
            if (!visited[in]) {
                dfs(in, adjacentList, visited, data);
            }
        }
    }
}
