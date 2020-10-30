package dev.manolovn.ceilingofanumber;

/**
 * Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
 * The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
 * <p>
 * Example:
 * Input: [4, 6, 10], key = 6
 * Output: 1
 * Explanation: The smallest number greater than or equal to '6' is '6' having index '1'
 * <p>
 * difficulty: MEDIUM
 * topics: BINARY SEARCH + ARRAYS
 */
public class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (key > arr[arr.length - 1])
            return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
