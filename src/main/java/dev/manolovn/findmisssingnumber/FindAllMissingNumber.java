package dev.manolovn.findmisssingnumber;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
 * The array has only one duplicate but it can be repeated multiple times.
 * Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
 *
 * Example:
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 *
 * Difficulty: EASY
 * Topics: ARRAYS + CYCLIC SORT
 */
public class FindAllMissingNumber {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        // cyclic sort
        while (i < nums.length) {
            int c = nums[i] - 1;
            if (c < nums.length && nums[i] != nums[c]) {
                swap(nums, i, c);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }

    private static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }
}
