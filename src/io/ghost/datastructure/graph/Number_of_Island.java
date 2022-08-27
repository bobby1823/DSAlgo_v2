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

        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[k].length; l++) {
                System.out.println("element: " + grid[k][l]);

                // checking for Island
                if (grid[k][l] == '1') {
                    numIsland_Dfs(grid, k, l, grid.length, grid[k].length);
                    numOfIsland += 1;
                }
            }
        }
        return numOfIsland;
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
    private static void numIsland_Dfs(char[][] grid, int i, int j, int c, int k) {
        // Pass the Grid matrix dimensions along with method. Since we won't able to get it. Or else Index out of bound
        // exception
        if ( i >= c || i < 0 || j >= k || j < 0 || grid[i][j] != '1') {
            return;
        }
//        else if (grid[i][j] != '1' ) {
//            return;
//        }
        // visited marked
        grid[i][j] = '2';
        System.out.println("element: "+ grid[i][j]);

        numIsland_Dfs(grid, i, j+1, c, k);
        numIsland_Dfs(grid, i, j-1, c, k);
        numIsland_Dfs(grid, i-1, j, c, k);
        numIsland_Dfs(grid, i+1, j, c, k);
    }
}
