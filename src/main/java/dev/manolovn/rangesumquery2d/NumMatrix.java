package dev.manolovn.rangesumquery2d;

/**
 * source: https://leetcode.com/problems/range-sum-query-2d-immutable/
 * difficulty: MEDIUM
 * topic: ARRAY + MATH
 */
public class NumMatrix {

    private int[][] dp;

    /**
     * We cache the cumulative sums from O to point X
     * So when we need to calculate the sum from (A,B) to (C,D) it will
     * sum(ABCD) = sum(0,D) - sum(0,B) - sum(OC) + sum(0A)
     *
     * Time:  O(1)
     * Space: O(m*n)
     */
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
