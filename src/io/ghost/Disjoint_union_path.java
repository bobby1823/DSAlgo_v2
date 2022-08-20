package io.ghost;

/**
 * Union Find Algorithm | Disjoint Set | Union By Rank & Path Compression
 * There will be two methods, This one is the basic implementation
 * Version-1: Here we are creating virtual tree where parent
 */
public class Disjoint_union_path {

    int [] p;
    int[] rank;
    //n is the number of elements
    Disjoint_union_path(int n) {
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        rank = new int[n];
    }

    public static void main(String[] args) {

    }

    int find_V1(int x) {
        if (x == this.p[x]) return x;
        return find_V1(p[x]);
    }

    // this is the union Method. This method makes the two element parent of another, if they doesn't contain a common parent.
    // Here in find() and union method the time complexity will be O(h*n) where h will be the height of virtual tree that
    // will be forming.
    public void union_V1(int x, int y) {
        int a = find_V1(x);
        int b = find_V1(y);
        // if both elements are same then it means they belong to same parent
        if (a == b) return;

        // Then we randomly choose one as parent of another
        // Making b as parent
        this.p[a] = b;
     }

    /**
     * Now we can further optimise the solution by shortening the Virtual Tree. Means by forming Maintaining Rank
     */
}
