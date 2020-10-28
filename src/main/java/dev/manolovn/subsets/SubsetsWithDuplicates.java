package dev.manolovn.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of numbers that might contain duplicates, find all of its distinct subsets
 * Example:
 * Input: [1, 3, 3]
 * Output: [], [1], [3], [1,3], [3,3], [1,3,3]
 * <p>
 * difficulty: EASY
 * topics: COMBINATIONS
 */
class SubsetsWithDuplicates {

    /**
     * The idea here is create all the subsets ordering the input previously;
     * so we know where the duplicates are. When a duplicate is found, to avoid to create
     * the same collections from previous iteration, we just create the sets from the previous number
     *
     * Time:  O(n2^n)
     * Space: O(n2^n)
     */
    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int from, to = 0;
        for (int n = 0; n < nums.length; n++) {
            from = 0;
            if (n > 0 && nums[n] == nums[n - 1]) {
                from = to + 1;
            }
            to = subsets.size() - 1;
            for (int i = from; i <= to; i++) {
                List<Integer> list = new ArrayList<>(subsets.get(i));
                list.add(nums[n]);
                subsets.add(list);
            }
        }
        return subsets;
    }
}
