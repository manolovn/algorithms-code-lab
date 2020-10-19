package dev.manolovn.subarrayproductlessthank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product
 * is less than the target number.
 *
 * Example:
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target
 *
 * Difficulty: MEDIUM
 * Topics: ARRAYS + SLIDING WINDOW + TWO POINTERS
 */
public class SubarrayProductLessThanK {

    /**
     * Time:  O(n^3)
     * Space: O(n^2)
     */
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int acc = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            acc *= arr[right];
            while (acc >= target && left < arr.length) {
                acc /= arr[left++];
            }

            List<Integer> temp = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                temp.add(0, arr[i]);
                subarrays.add(new ArrayList<>(temp));
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
