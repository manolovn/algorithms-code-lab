package dev.manolovn.nextpermutation;

/**
 * source: https://leetcode.com/problems/next-permutation/
 * difficulty: MEDIUM
 * topic: MATH + ARRAYS
 */
public class NextPermutation {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;

        int i = nums.length - 2;
        // find first decreasing element
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;

        if (i >= 0) {
            // find first number greater than nums[i]
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
