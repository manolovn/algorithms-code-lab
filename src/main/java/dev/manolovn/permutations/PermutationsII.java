package dev.manolovn.permutations;

import java.util.*;

/**
 * source: https://leetcode.com/problems/permutations-ii/
 * difficulty: MEDIUM
 * topics: RECURSION + PERMUTATIONS
 */
public class PermutationsII {

    /**
     * Time: O(n!)
     * Space: O(n)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb, nums.length, map, perms);

        return perms;
    }

    private void backtrack(LinkedList<Integer> comb, int n, Map<Integer, Integer> map, List<List<Integer>> perms) {
        if (comb.size() == n) {
            perms.add(new ArrayList<>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (count == 0) continue;

            comb.addLast(num);
            map.put(num, count - 1);

            backtrack(comb, n, map, perms);

            comb.removeLast();
            map.put(num, count);
        }
    }
}
