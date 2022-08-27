package io.ghost.datastructure.graph;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 */
public class Number_of_Island {

    public static void main(String[] args) {
        char[][] island = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of Island: " +numIslands(island));
    }

    public static int numIslands(char[][] grid) {
        int numOfIsland = 0;
        numIsland_Dfs(grid, 0, 0, numOfIsland);
        return numOfIsland;
    }

    // we will apply DFS here. Will traverse in each element to check 
    private static void numIsland_Dfs(char[][] grid, int i, int j, int numOfIsland) {
        if ((i+1 <= grid.length) && (i-1 >= 0) && (j+1 <= grid[0].length) && (j-1 >= 0)
                && grid[i][j] == '1' ) {
            numOfIsland += 1;
        }
        grid[i][j] = 2;
        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[k].length; l++) {
                System.out.println("element: "+ grid[k][l]);
                numIsland_Dfs(grid, k, l, numOfIsland);
            }
        }
    }
}
