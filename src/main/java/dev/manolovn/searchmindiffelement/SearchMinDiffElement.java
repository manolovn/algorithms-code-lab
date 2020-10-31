package dev.manolovn.searchmindiffelement;

/**
 * Given an array of numbers sorted in ascending order, find the element in the array that has the minimum
 * difference with the given ‘key’
 * Example :
 * Input: [4, 6, 10], key = 7
 * Output: 6
 * Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
 * <p>
 * difficulty: MEDIUM
 * topics: BINARY SEARCH
 */
public class SearchMinDiffElement {

    /**
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int searchMinDiffElement(int[] arr, int key) {
        int element = 0;
        int diff = key;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int cDiff = key - arr[mid];
            if (cDiff < 0) {
                end = mid - 1;
            } else if (cDiff > 0) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
            if (Math.abs(cDiff) < diff) {
                diff = Math.abs(cDiff);
                element = arr[mid];
            }
        }
        return element;
    }

    /**
     * Alternative solution
     * Time:  O(logn)
     * Space: O(1)
     */
    public static int searchMinDiffElement_alt(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }

        // after the while loop, start == end+1; so one of them is the solution
        if ((arr[start] - key) < (key - arr[end])) {
            return arr[start];
        }
        return arr[end];
    }
}
