package io.ghost.datastructure;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_Algo {

    /**
     * First we take the vertex whose starting point we need. And then we add that in Priority Queue.
     * This is a Greedy Algorithm.
     */

    public static void main(String[] args) {

    }

    public static void dijkstraAlgo(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V, int S, int toPoint) {
        int[] arrAns = new int[V];
        // Putting Max value in the array of lengths of vertices
        for (int i = 0; i < V; i++) {
            arrAns[i] = Integer.MAX_VALUE;
        }
        // making 0 length for the starting point.
        arrAns[S] = 0;
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(S,0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int v = cur.v;
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            ArrayList<ArrayList<Integer>> neighbour = adj.get(v);
            for (ArrayList<Integer> el : neighbour) {
                int vertex = el.get(0);
                int weight = el.get(1);
                // checking if the current node is already visited. If no then checking the current distance from
                // Ans Array (ansArr[vertex]) with weight + length of path till from source till now.
                if (!visited[vertex] && arrAns[vertex] > (weight + arrAns[v])) {
                    arrAns[vertex] = (weight + arrAns[v]);
                    queue.add(new Pair(vertex, arrAns[vertex]));
                }
            }
        }
    }
}
