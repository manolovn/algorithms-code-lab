package dev.manolovn.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * source: https://leetcode.com/problems/permutations/
 * difficulty: MEDIUM
 * topic: SUBSETS + RECURSION + PERMUTATION + BACKTRACKING
 */
public class PermutationsLC {

    /*
     *----*
    [1,2,3]-----------
       |   \          \
    [1,2,3] [2,1,3] [3,2,1]
       *-*     *-*     *-* --> generating the recursion tree

    #1: backtracking
    Time:  O(n!)
    Space: O(n!)
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ns = new ArrayList<>();
        for (int n : nums) ns.add(n);

        rec(ns, 0, result);
        return result;
    }

    private void rec(List<Integer> nums, int idx, List<List<Integer>> result) {
        if (idx == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = idx; i < nums.size(); i++) {
            Collections.swap(nums, idx, i);
            rec(nums, idx + 1, result);
            Collections.swap(nums, idx, i);
        }
    }
}
