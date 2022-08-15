package io.ghost.datastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the sum of weights of edges of Minimum Spanning Tree
 */
public class MinimumSpanningTree_PrimAlgo {

    public static void main(String[] args) {

    }

    // Note that to define the weight of edges we need to use ArrayList of ArrayList of ArrayList weight
    public static int spanningTree(ArrayList<ArrayList<ArrayList<Integer>>> adjacencyList, int n) {
        int ans = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        // Initially we will start from 0 vertex and weight will be 0.
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int v = currentPair.v;
            if (visited[v]) {
                continue;
            }
            // Marking v Vertex as visited
            visited[v] = true;
            // Adding minimum edge weight to answer. Min Heap.... So no need to worry about find the minimum.
            // O(log(E)), where E is the number of Edges that Queue will contain. We can optimise this part.
            ans += currentPair.wt;

            ArrayList<ArrayList<Integer>> neighbours = adjacencyList.get(v);
            for (ArrayList<Integer> l : neighbours) {
                int vertex = l.get(0);
                int weight = l.get(1);
                if (!visited[vertex]) {
                 queue.add(new Pair(vertex, weight));
                }
            }
        }
        return ans;
    }

}

// This implementation of Comparable is being made because of Minimum heap based on weight of graph edges.
class Pair implements Comparable<Pair> {
    int v;
    int wt;
    public Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }

    @Override
    public int compareTo(Pair that) {
        return this.wt - that.wt;
    }
}
