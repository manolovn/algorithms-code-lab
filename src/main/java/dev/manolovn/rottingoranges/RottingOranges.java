package dev.manolovn.rottingoranges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * source: https://leetcode.com/problems/rotting-oranges/
 * Difficulty: MEDIUM
 */
public class RottingOranges {

    /*
    Given n and m are the grid dimensions
    Time:  O(m*n) ; because traversing all the grid
    Space: O(m*n) ; in the worst case, all the cells are added to the queue
    */
    public int orangesRotting(int[][] grid) {
        int minutes = -1;
        int fresh = 0;
        // 1. count fresh oranges and add to queue rotten ones
        Queue<int[]> q = new LinkedList<>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    fresh++;
                }
                if (grid[x][y] == 2) {
                    q.offer(new int[]{x, y});
                }
            }
        }

        // 2. check initial state
        if (fresh == 0) return 0; // no fresh oranges
        if (q.isEmpty()) return -1; // no rotten oranges
        if (q.size() == (grid.length * grid[0].length)) return 0; // all oranges are rotten

        // 3. bfs like traversing counting minutes
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                int[] curr = q.poll();
                int cx = curr[0];
                int cy = curr[1];

                if (isValid(grid, cx, cy + 1)) {
                    grid[cx][cy + 1] = 2;
                    fresh--;
                    q.offer(new int[]{cx, cy + 1});
                }
                if (isValid(grid, cx, cy - 1)) {
                    grid[cx][cy - 1] = 2;
                    fresh--;
                    q.offer(new int[]{cx, cy - 1});
                }
                if (isValid(grid, cx + 1, cy)) {
                    grid[cx + 1][cy] = 2;
                    fresh--;
                    q.offer(new int[]{cx + 1, cy});
                }
                if (isValid(grid, cx - 1, cy)) {
                    grid[cx - 1][cy] = 2;
                    fresh--;
                    q.offer(new int[]{cx - 1, cy});
                }
                size--;
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    private boolean isValid(int[][] m, int x, int y) {
        return x >= 0 && x < m.length && y >= 0 && y < m[x].length && m[x][y] == 1;
    }
}
