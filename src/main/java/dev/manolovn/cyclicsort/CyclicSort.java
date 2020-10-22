package dev.manolovn.cyclicsort;

/**
 * Sort the input in-place without extra space
 *
 * Example:
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 */
public class CyclicSort {

    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }
}
