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
    public int find_v2(int x) {
        if (x != p[x]) {
            // getting the parent of p[x] and connect it with
            p[x] = find_v2(p[x]);
        }
        return x;
    }

    /**
     * Now we can further optimise the solution by shortening the Virtual Tree. Means by forming Maintaining Rank
     * meaning. Initially all the elements will be of same rank. Now if both the elements belongs to same rank
     * then we will randomly choose one parent and increment the rank of chosen element as parent to +1. There by folding
     * the tree. And reducing the height
     */
    public void union_V2(int x, int y) {
        int a = find_v2(x);
        int b = find_v2(y);

        if (a == b) return;

        if (rank[a] > rank[b]) {
            p[b] = a;
        } else if (rank[a] < rank[b]) {
            p[a] = b;
        } else if (rank[a] == rank[b]) {
            p[b] = a;
            rank[a]= rank[a] + 1;
        }
    }
}
