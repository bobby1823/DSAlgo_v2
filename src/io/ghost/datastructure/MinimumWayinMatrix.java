package io.ghost.datastructure;

/**
 * You have given a 4*3 matrix. You are starting from  Find the
 */
public class MinimumWayinMatrix {

    public static void main(String[] args) {
        int n = 4; int m = 3;
        System.out.println("Minium way to cross a matrix: " + findMinimumPossibleWay(m,n));
    }

    private static int findMinimumPossibleWay(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        return findMinimumPossibleWay(n-1, m) +findMinimumPossibleWay(n, m-1);
    }
}
