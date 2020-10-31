package dev.manolovn.findsortedrange;

public class FindSortedRange {

    /**
     * Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
     * The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
     * Example:
     * Input: [4, 6, 6, 6, 9], key = 6
     * Output: [1, 3]
     * <p>
     * Time:  O(logn)
     * Space: O(1)
     * <p>
     * difficulty: MEDIUM
     * topics: BINARY SEARCH
     */
    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[]{-1, -1};
        // these two functions are easily to change to only one function
        // but I think keeping the two functions as separated makes the solution
        // easier to read. Sorry for the copy-pasting
        result[0] = findRangeStart(arr, key); // O(logn)
        result[1] = findRangeEnd(arr, key); // O(logn)
        return result; // O(logn) + O(logn) = 2O(logn) = O(logn)
    }

    private static int findRangeStart(int[] arr, int key) {
        int idx = -1;
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                idx = mid;
                end = mid - 1;
            }
        }
        return idx;
    }

    private static int findRangeEnd(int[] arr, int key) {
        int idx = -1;
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                idx = mid;
                start = mid + 1;
            }
        }
        return idx;
    }
}
