package dev.manolovn.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode.com/problems/4sum/
 * difficulty: MEDIUM
 * topics: ARRAYS
 */
public class FourSum {

    /**
     * Time:  O(n^3)
     * Space: O(n)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> sols = new ArrayList<>();

        int istart = 0;
        for (int i = istart; i < nums.length; i++) { // 4sum
            if (i == istart || nums[i - 1] != nums[i]) {
                int start = i + 1;
                for (int j = start; j < nums.length; j++) { // 3sum
                    if (j == start || nums[j - 1] != nums[j]) {
                        List<List<Integer>> r = sum2(nums, j + 1, target - nums[i] - nums[j]); // 2sum
                        for (List<Integer> set : r)
                            sols.add(
                                    new ArrayList<>(Arrays.asList(nums[i], nums[j], set.get(0), set.get(1)))
                            );
                    }
                }
            }
        }

        return sols;
    }

    private List<List<Integer>> sum2(int[] nums, int start, int target) {
        List<List<Integer>> sols = new ArrayList<>();
        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target || (l > start && nums[l] == nums[l - 1])) l++;
            else if (sum > target || (r < nums.length - 1 && nums[r] == nums[r + 1])) r--;
            else {
                sols.add(new ArrayList<>(Arrays.asList(nums[l++], nums[r--])));
            }
        }
        return sols;
    }
}
