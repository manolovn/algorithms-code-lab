package dev.manolovn.searchinfinitesortedarray;

/**
 * Given an infinite sorted array (or an array with unknown size), find if a given number ‘key’ is present in the array
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1
 * <p>
 * Example:
 * Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
 * Output: 6
 * Explanation: The key is present at index '6' in the array
 * <p>
 * difficulty: MEDIUM
 * topics: BINARY SEARCH
 */
class SearchInfiniteSortedArray {

    /**
     * Time:  O(logn)
     * Space: O(1)
     */
    public int search(ArrayReader reader, int key) {
        int start = 0;
        int end = 1;
        while (reader.get(end) < key) {
            end *= 2;
        } // O(logn)
        return binarySearch(reader, start, end, key); // O(logn)
    }

    private int binarySearch(ArrayReader reader, int start, int end, int key) {
        int idx = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) > key) {
                end = mid - 1;
            } else if (reader.get(mid) < key) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return idx;
    }

    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }
}
