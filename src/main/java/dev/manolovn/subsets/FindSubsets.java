package dev.manolovn.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set with distinct elements, find all of its distinct subsets
 * Example:
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 *
 * difficulty: EASY
 * topics: SUBSETS + COMBINATIONS
 */
public class FindSubsets {

    /**
     * Time:  O(n2^n)
     * Space: O(n2^n)
     */
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int n : nums) {
            int s = subsets.size();
            for (int i = 0; i < s; i++) {
                List<Integer> list = new ArrayList<>(subsets.get(i));
                list.add(n);
                subsets.add(list);
            }
        }
        return subsets;
    }
}
