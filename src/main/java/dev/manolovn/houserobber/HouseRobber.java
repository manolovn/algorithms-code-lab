package dev.manolovn.houserobber;

/**
 * source: https://leetcode.com/problems/house-robber/
 * difficulty: EASY
 * topic: ARRAYS + DP
 */
public class HouseRobber {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;
        for (int n : nums) {
            int tmp = curr;
            curr = Math.max(prev + n, curr);
            prev = tmp;
        }
        return curr;
    }

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public int rob_alternative(int[] nums) {
        int even = 0;
        int odd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even += nums[i];
                even = Math.max(even, odd);
            } else {
                odd += nums[i];
                odd = Math.max(even, odd);
            }
        }

        return Math.max(even, odd);
    }
}
