package dev.manolovn.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Obtain all the permutations from an int array
 *
 * difficulty: MEDIUM
 * topics: PERMUTATIONS
 */
class Permutations {

    /**
     * The idea is a recursive approach swapping the input
     * Time:  O(n!)
     * Space: O(n!) ; ignoring the size of the result structure because is a problem requirement
     *                but taking into account the recursion stack
     */
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums.length, nums, result);
        return result;
    }

    private static void helper(int size, int[] nums, List<List<Integer>> result) {
        if (size == 1) {
            result.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = 0; i < size-1; i++) {
                helper(size-1, nums, result);
                if (i % 2 == 0) {
                    swap(nums, i, size-1);
                } else {
                    swap(nums, 0, size-1);
                }
            }
            helper(size-1, nums, result);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
