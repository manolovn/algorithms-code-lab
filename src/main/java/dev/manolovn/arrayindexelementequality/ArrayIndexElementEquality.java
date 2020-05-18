package dev.manolovn.arrayindexelementequality;

public class ArrayIndexElementEquality {

    /**
     * We know that the input is sorted, so a simple array traverse will give us O(n) in time
     * but taking into account the sorting, a binary search improves the solution to O(log n) at worst
     *
     * Time:  O(log n)
     * Space: O(1) ; no need extra data structures
     */
    static int indexEqualsValueSearch(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // lo = 1000 hi = Integer.MAX_VALUE
            int mid = low + (high - low) / 2;
            if (arr[mid] < mid) {
                low = mid + 1;
            } else if (arr[mid] > mid) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
