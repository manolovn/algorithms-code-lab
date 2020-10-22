package dev.manolovn.findmisssingnumber;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates,
 * which means some numbers will be missing. Find all those missing numbers.
 *
 * Example:
 * Input: [2, 3, 1, 8, 2, 3, 5, 1]
 * Output: 4, 6, 7
 * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
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
