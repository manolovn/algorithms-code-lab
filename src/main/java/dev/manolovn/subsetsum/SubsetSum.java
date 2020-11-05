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

    /**
     * improved solution with O(s) space complexity
     */
    public boolean canPartition_improved(int[] num, int sum) {
        int n = num.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // base case

        // with only one number, we can have a subset only when the required sum is equal to its value
        for (int s = 1; s <= sum; s++) {
            dp[s] = num[0] == s;
        }

        // process all subsets for all sums
        for (int i = 1; i < n; i++) {
            for (int s = sum; s >= 0; s--) {
                // if dp[s]==true, this means we can get the sum 's' without num[i], hence we can move on to
                // the next number else we can include num[i] and see if we can find a subset to get the
                // remaining sum
                if (!dp[s] && s >= num[i]) {
                    dp[s] = dp[s - num[i]];
                }
            }
        }

        return dp[sum];
    }
}
