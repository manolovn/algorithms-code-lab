package dev.manolovn.intersectionoftwoarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * difficulty: EASY
 * topics: ARRAYS
 */
public class IntersectionOfTwoArraysII {

    /*
    time:  O(n+m)
    space: O(min(n,m))
    where n is nums1 length and m is nums2 length
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1); // to minimize the map
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) map.put(n, map.getOrDefault(n, 0) + 1);

        int k = 0;
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                map.put(n, map.get(n) - 1);
                nums1[k++] = n;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }
}
