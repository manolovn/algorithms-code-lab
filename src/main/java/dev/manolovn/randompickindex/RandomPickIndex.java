package dev.manolovn.randompickindex;

import java.util.*;

/**
 * source: https://leetcode.com/problems/random-pick-index/
 * difficulty: MEDIUM
 * topic: RESERVOIR SAMPLING
 * help: https://en.wikipedia.org/wiki/Reservoir_sampling
 */
public class RandomPickIndex {

    // map { number => list of indices }
    private final Map<Integer, List<Integer>> indices;
    private final Random rand;

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public RandomPickIndex(int[] nums) {
        rand = new Random();
        indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indices.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
    }

    /**
     * Time:  O(1)
     * Space: O(1)
     */
    public int pick(int target) {
        List<Integer> targetList = indices.get(target);
        return targetList.get(rand.nextInt(targetList.size()));
    }
}
