package dev.manolovn.orderagnostic;

/**
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
 * Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 * You should assume that the array can have duplicates.
 * Example:
 * Input: [4, 6, 10], key = 10
 * Output: 2
 *
 * difficulty: EASY
 * topics: BINARY SEARCH
 */
public class OrderAgnosticBinarySearch {

    /**
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int search(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        boolean isAsc = arr[r] > arr[l];
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == key) {
                return m;
            }
            if (isAsc) {
                if (key < arr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (key > arr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
