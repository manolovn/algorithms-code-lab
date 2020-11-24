package dev.manolovn.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode.com/problems/3sum/
 * difficulty: MEDIUM
 * topic: ARRAYS
 */
public class ThreeSum {

    /**
     * Time:  O(n^2)
     * Space: O(n)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                sum2(nums, i, ans);
            }
        }
        return ans;
    }

    private void sum2(int[] nums, int start, List<List<Integer>> ans) {
        int l = start + 1;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[start] + nums[l] + nums[r];
            if (sum < 0) {
                l++;
            } else if (sum > 0) {
                r--;
            } else {
                ans.add(Arrays.asList(nums[start], nums[l], nums[r]));
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) l++;
            }
        }
    }
}
