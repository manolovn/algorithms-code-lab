package dev.manolovn.intersectionoftwoarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/intersection-of-two-arrays/
 * difficulty: EASY
 * topics: ARRAYS
 */
public class IntersectionOfTwoArrays {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> solution = new HashSet<>();
        for (int n : nums1) set.add(n);
        for (int n : nums2) {
            if (set.contains(n)) {
                solution.add(n);
            }
        }
        int[] out = new int[solution.size()];
        int i = 0;
        for (int n : solution) {
            out[i++] = n;
        }
        return out;
    }
}
