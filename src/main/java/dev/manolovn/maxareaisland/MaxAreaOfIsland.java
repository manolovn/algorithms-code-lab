package dev.manolovn.maxareaisland;

import java.util.LinkedList;
import java.util.Queue;

/**
 * source: https://leetcode.com/problems/max-area-of-island/
 * difficulty: MEDIUM
 * topic: DFS + BFS
 */
public class MaxAreaOfIsland {

    /*
    t: O(m*n)
    s: O(m*n)
    */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int i, int j) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int area = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            area++;
            // add neighbors
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x >= 0 && x < grid.length
                        && y >= 0 && y < grid[0].length
                        && grid[x][y] == 1) {
                    q.offer(new int[]{x, y});
                    grid[x][y] = 0;
                }
            }
        }
        return area;
    }
}
