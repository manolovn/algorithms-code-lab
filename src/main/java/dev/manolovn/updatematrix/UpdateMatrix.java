package dev.manolovn.updatematrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * source: https://leetcode.com/problems/01-matrix/
 * difficulty: MEDIUM
 * topic: TREE + GRAPH + BFS + DP + ARRAY
 */
public class UpdateMatrix {

    /**
     * Time:  O(n^2)
     * Space: O(n)
     */
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return matrix;
        int cols = matrix[0].length;

        int[][] dist = new int[rows][cols];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new int[]{i,j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][]{ {-1,0},{1,0},{0,1},{0,-1} };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = curr[0] + dirs[i][0];
                int c = curr[1] + dirs[i][1];
                if (r >= 0 && c >= 0 && r < rows && c < cols) {
                    if (dist[r][c] > dist[curr[0]][curr[1]] + 1) {
                        dist[r][c] = dist[curr[0]][curr[1]] + 1;
                        q.add(new int[]{r,c});
                    }
                }
            }
        }

        return dist;
    }
}
