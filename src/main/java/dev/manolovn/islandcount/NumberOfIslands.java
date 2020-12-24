package dev.manolovn.islandcount;

import java.util.LinkedList;
import java.util.Queue;

/**
 * source: https://leetcode.com/problems/number-of-islands
 * difficulty: MEDIUM
 * topic: BFS + DFS
 */
public class NumberOfIslands {

    int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    /**
     * Time:  O(n*m)
     * Space: O(n*m)
     * n and m are the dimensions of the grid.
     * In the worst cases we need to traverse the full grid.
     */
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    visitIslandRecursive(grid, i, j);
                    //visitIslandIterative(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    /**
     * Recursive implementation based on recursive DFS
     */
    private void visitIslandRecursive(char[][] grid, int i, int j) {
        if (!isValid(grid, i, j)) return;
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            visitIslandRecursive(grid, i + dir[0], j + dir[1]);
        }
    }

    /**
     * Iterative implementation based on BFS
     */
    private void visitIslandIterative(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int[] dir : dirs) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (isValid(grid, x, y)) {
                    grid[x][y] = '0';
                    q.add(new int[]{x, y});
                }
            }
        }
    }

    private boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == '1';
    }
}
