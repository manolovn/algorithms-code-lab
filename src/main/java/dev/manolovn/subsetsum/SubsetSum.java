package dev.manolovn.subsetsum;

/**
 * Given a set of positive numbers, determine if a subset exists whose sum is equal to a given number ‘S’
 *
 * Example:
 * Input: {1, 2, 3, 7}, S=6
 * Output: True
 * The given set has a subset whose sum is '6': {1, 2, 3}
 *
 * difficulty: MEDIUM
 * topics: DYNAMIC PROGRAMMING
 */
public class SubsetSum {

    /**
     * bottom-up approach
     * Time and Space: O(n*s) ; where n is the num length and s is sum
     */
    public boolean canPartition(int[] num, int sum) {
        int n = num.length;
        if (n == 0) return false;

        boolean[][] dp = new boolean[n][sum + 1];
        // column base case, that is an empty set
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // row base case, when the first number is equal to the sum
        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = num[0] == i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                } else if (j >= num[i]) {
                    dp[i][j] = dp[i-1][j-num[i]];
                }
            }
        }
        return dp[n-1][sum];
    }
}
