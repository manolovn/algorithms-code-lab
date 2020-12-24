package dev.manolovn.numberofclosedislands;

/**
 * source: https://leetcode.com/problems/number-of-closed-islands/
 * difficulty: MEDIUM
 * topic: DFS
 */
public class NumberOfClosedIslands {

    int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    /**
     * Time:  O(n*m)
     * Space: O(n*m)
     * n and m are the dimensions of the grid,
     * in the worst case we need to fully traverse the grid
     */
    public int closedIsland(int[][] grid) {
        int islands = 0;

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && isClosedIsland(grid, i, j)) {
                    islands++;
                }
            }
        }

        return islands;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return false;
        if (grid[i][j] == 1) return true;

        grid[i][j] = 1;
        boolean isClosed = true;
        for (int[] dir : dirs) {
            isClosed &= isClosedIsland(grid, i + dir[0], j + dir[1]);
        }
        return isClosed;
    }
}
