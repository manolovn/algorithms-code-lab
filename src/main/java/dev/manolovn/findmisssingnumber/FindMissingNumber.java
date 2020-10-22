package dev.manolovn.findmisssingnumber;

/**
 * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
 * Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
 *
 * Example:
 * Input: [4, 0, 3, 1]
 * Output: 2
 *
 * Difficulty: EASY
 * Topics: ARRAYS + CYCLIC SORT
 */
public class FindMissingNumber {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static int findMissingNumber(int[] nums) {
        // cyclic sort
        int i = 0;
        while (i < nums.length) {
            int c = nums[i];
            if (c < nums.length && c != nums[c]) {
                swap(nums, i, c);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    private static void swap(int[] arr, int a, int b) {
        int x = arr[a];
        arr[a] = arr[b];
        arr[b] = x;
    }
}
