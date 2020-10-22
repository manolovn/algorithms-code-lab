package dev.manolovn.findtheduplicates;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
 * The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.
 *
 * Example :
 * Input: [3, 4, 4, 5, 5]
 * Output: [4, 5]
 *
 * Difficulty: EASY
 */
public class FindAllDuplicatedNumbers {

    /**
     * Time:  O(n)
     * Space: O(1) ; ignoring the space needed to store the duplicated
     */
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicateNumbers.add(nums[i]);
            }
        }
        return duplicateNumbers;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
