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
}
