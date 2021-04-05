package dev.manolovn.uniquepathswithobstacles;

/**
 * source: https://leetcode.com/problems/unique-paths/
 * difficulty: MEDIUM
 * topic: DYNAMIC PROGRAMMING
 */
public class UniquePaths {

    /*
    [ ][ ][ ]
    [ ][ ][ ]

    1. using dp (bottom up) >> time: O(m*n); space: O(m*n) [OKish]
        - fill the matrix with 1s
        - calculate the matrix
        1a. using dp (bottom up) >> time: O(m*n); space: O(n) [OK]
            - fill [0,0] = 1 into an array with dimen n
            - calculate the matrix
    2. using dfs >> time: O(m*n); space: O(m*n) + Node creation [KO]
    3. recursion (top down) + memoization >> time: O(m*n); space: O(m*n)

    */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
