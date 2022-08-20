package io.ghost.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumSpanning_tree_Kruskal_Algo {

    static int[] p;

    static int[] rank;

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return x;
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return;

        if (rank[a] > rank[b]) {
            p[b] = a;
        } else if (rank[b] > rank[a]) {
            p[a] = b;
        } else {
            p[a] = b;
            rank[b] = rank[b]+1;
        }

    }
    public int findMinimumSpanningTree_KruskalAlgo(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int ans = 0;

        // Here we are trying to convert the Adjacency list to adjacency matrix and List of edges.
        // This matrix will contain if edge has been added or not.
        boolean[][] added = new boolean[V][V];

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j <adj.get(i).size(); j++) {
                ArrayList<Integer> current = adj.get(i).get(j);
                int j1 = current.get(0); // this is the destination.
                if (!added[i][j1]) {
                    added[i][j1] = true;
                    added[j1][i] = true;
                    // Adding the edge
                    edges.add(new Edge(i,j1, current.get(1)));
                }
            }
        }
        rank = new int[V];
        p = new int[V];
        // Sorting the List of edges
        Collections.sort(edges);
        for (int i = 0; i < V; i++) {
            p[i] = i;
        }

        int count = 1;
        // Main logic
        // The structure of loop is like this because we will break from the loop only when all the vertices have been visited
        // means we are union V-1
        for (int i = 0; count < V; i++) {
            Edge edge = edges.get(i);
            // Initially p array elements will be their own parent. So, Union operation will happen since staring below condition
            // will hold true.
            if (find(edge.src) != find(edge.dest)) {
                union(edge.src, edge.dest);
                ans += edge.wt;
                count = count + 1;
            }
        }
        return ans;
    }
}

class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int wt;

    Edge(int src, int dest, int wt) {
        this.dest = dest;
        this.src = src;
        this.wt = wt;
    }


    @Override
    public int compareTo(Edge other) {
        return this.wt - other.wt;
    }
}
