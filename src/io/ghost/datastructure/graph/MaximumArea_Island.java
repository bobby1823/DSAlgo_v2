package io.ghost.datastructure.graph;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 */
public class MaximumArea_Island {

    public static int areaCount = 0;
    public static int maxAreaCount = 0;

    public static void main(String[] args) {
        int[][] island = {
                {0,0,0,0,0,0,0,0}
//                {1, 1, 1, 1, 0},
//                {1, 1, 0, 1, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0}
        };
        System.out.println("Area of Island: " +numIslands(island));
    }

    public static int numIslands(int[][] grid) {
        int numOfIsland = 0;

        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[k].length; l++) {
                System.out.println("element: " + grid[k][l]);

                // checking for Island
                if (grid[k][l] == 1) {
                    numIsland_Dfs(grid, k, l, grid.length, grid[k].length);
                    // Till here we will get all the connect parts of graph.
                    numOfIsland += 1;
                    maxAreaCount = Integer.max(maxAreaCount, areaCount);
                    // Resetting the areaCounter
                    areaCount = 0;
                }
            }
        }
        return maxAreaCount;
    }

    /**
     * {
     *                 {'1', '1', '1', '1', '0'},
     *                 {'1', '1', '0', '1', '0'},
     *                 {'1', '1', '0', '0', '0'},
     *                 {'0', '0', '0', '0', '0'}
     *         }
     */
    // we will apply DFS here. Will traverse in each element to check
    private static void numIsland_Dfs(int[][] grid, int i, int j, int c, int k) {
        // Pass the Grid matrix dimensions along with method. Since we won't able to get it. Or else Index out of bound
        // exception
        if ( i >= c || i < 0 || j >= k || j < 0 || grid[i][j] != 1) {
            return;
        }
//        else if (grid[i][j] != '1' ) {
//            return;
//        }
        // visited marked
        grid[i][j] = 2;
        areaCount+=1;
//        System.out.println("element: "+ grid[i][j]);

        numIsland_Dfs(grid, i, j+1, c, k);
        numIsland_Dfs(grid, i, j-1, c, k);
        numIsland_Dfs(grid, i-1, j, c, k);
        numIsland_Dfs(grid, i+1, j, c, k);
    }
}
