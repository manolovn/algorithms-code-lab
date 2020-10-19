package dev.manolovn.tripletsmallersum;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such
 * that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 * <p>
 * Example:
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 *
 * Difficulty: MEDIUM
 * Topics: ARRAYS + TWO POINTERS
 */
public class TripletWithSmallerSum {

    /**
     * Time:  O(nlogn) + O(n^2) = O(n^2)
     * Space: O(n) ; due to the space needed to sort
     */
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (end > start) {
                if (arr[i] + arr[start] + arr[end] < target) {
                    // tricky point, such we already found a triplet, the rest of the triplets between
                    // end and start pointers are solution too
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
