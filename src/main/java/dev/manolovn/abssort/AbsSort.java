package dev.manolovn.abssort;

import java.util.Arrays;

/**
 * Given an array of integers arr, write a function absSort(arr),
 * that sorts the array according to the absolute values of the numbers in arr.
 * If two numbers have the same absolute value, sort them according to sign,
 * where the negative numbers come before the positive numbers.
 *
 * Example:
 * input:  arr = [2, -7, -2, -2, 0]
 * output: [0, -2, -2, 2, -7]
 *
 * difficulty: EASY
 * topic: SORTING
 */
public class AbsSort {

    static int[] absSort(int[] array) {
        Integer[] arr = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int diff = Math.abs(a) - Math.abs(b);
            if (diff == 0) {
                return a - b;
            }
            return diff;
        });

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}
