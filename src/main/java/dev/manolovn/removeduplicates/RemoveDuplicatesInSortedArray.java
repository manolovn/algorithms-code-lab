package dev.manolovn.removeduplicates;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
 * after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 *
 * Example:
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 *
 * source: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Difficulty: EASY
 * Topics: ARRAYS + TWO POINTERS
 */
public class RemoveDuplicatesInSortedArray {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static int remove(int[] arr) {
        int next = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[next - 1] != arr[i]) {
                arr[next] = arr[i];
                next++;
            }
        }
        return next;
    }
}
