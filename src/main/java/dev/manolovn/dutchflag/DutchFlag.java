package dev.manolovn.dutchflag;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 * Difficulty: MEDIUM
 * Topics: ARRAYS + TWO POINTERS
 * Source: https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 */
public class DutchFlag {

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int i = 0;
        while (i <= right) {
            if (arr[i] == 0) {
                swap(arr, i, left);
                i++;
                left++;
            } else if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, right);
                right--;
            }
        }
    }

    private static void swap(int[] arr, int f, int t) {
        int temp = arr[t];
        arr[t] = arr[f];
        arr[f] = temp;
    }
}
