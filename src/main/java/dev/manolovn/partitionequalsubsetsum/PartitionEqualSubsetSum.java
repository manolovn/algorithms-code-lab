package dev.manolovn.partitionequalsubsetsum;

public class PartitionEqualSubsetSum {

    /*
    [1, 5, 11, 5]
    true -> [1,5,5] = [11]

    [x] #1 top-down approach + memoization >> time: O(n^2) space: O(n^2)
            - recursive
        #2 bottom-up approach (dp) >> time: O(n^2) space: O(n^2)
            - sum all values -> total
                total % 2
            - target = total/2
                [1, 5, 11, 5] = [1] [5, 11, 5] || [1, 5] [11, 5] || ...
                 ^ ---------
                 -- ^ ------
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
                                               ^
        #3 greedy approach? [not found :/]

    */
    public static boolean canPartition_withDP(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = dp[j] || (j >= nums[i - 1] && dp[j - nums[i - 1]]);
            }
        }
        return dp[target];
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        return recursive(nums, nums.length - 1, 0, sum / 2);
    }

    private static boolean recursive(int[] nums, int k, int currentSum, int targetSum) {
        if (k < 0 || currentSum > targetSum) return false;
        if (nums[k] > targetSum) return false;
        if (currentSum == targetSum) return true;
        return recursive(nums, k - 1, currentSum + nums[k], targetSum) || recursive(nums, k - 1, currentSum, targetSum);
    }
}
