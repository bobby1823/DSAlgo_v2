package io.ghost.datastructure;

// Here the rotation happens  every in one direction i.e: left to right. NOT ALTERNATIVE
public class GameOfExecution_JosephusProblem {

    public static void main(String[] args) {
        System.out.println("Index of person who will survive: " +getIndexOfSurvivour(9, 1));
    }

    // Example: n=5, k=3 || 0,1,2,3,4
    public static int getIndexOfSurvivour(int n, int k) {
        if (n == 1) return 0;
        int x = getIndexOfSurvivour(n-1, k);
        int y = (x + k) % n;
        return y;
    }
}
