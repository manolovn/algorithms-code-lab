package dev.manolovn.findtheduplicates;

import java.util.Arrays;

public class FindTheDuplicates {

    /*
      ar1: [1, 2, 3, 5, 6, 7]
      ar2: [3, 6, 7, 8, 20]
      [3, 6, 7]

      1. using a map with ar1 values t:O(n+m) n is arr2; space O(m) m is arr1
      Assuming the arr1 and arr2 are sorted
      2. using a binary search. time: O(m * log n)
      #1 is better until arr2 >> arr1; so #2 is better when arr2 >> arr1
    */
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        int[] solution = new int[arr1.length];
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (binarySearch(arr1, arr2[i])) {
                solution[i] = arr2[i];
                count++;
            }
        }
        return Arrays.copyOfRange(solution, 0, count);
    }

    /*
      Find k in arr and return true if exists
    */
    private static boolean binarySearch(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        boolean exists = false;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if (arr[mid] < k) {
                lo = mid + 1;
            } else if (arr[mid] > k) {
                hi = mid - 1;
            } else if (arr[mid] == k) {
                exists = true;
                break;
            }
        }
        return exists;
    }
}
