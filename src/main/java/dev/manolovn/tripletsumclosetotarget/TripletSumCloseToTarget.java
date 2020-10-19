package dev.manolovn.tripletsumclosetotarget;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close
 * to the target number as possible, return the sum of the triplet. If there are more than one such triplet,
 * return the sum of the triplet with the smallest sum.
 * <p>
 * Example :
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * <p>
 * Difficulty: MEDIUM
 * Topics: ARRAYS + TWO POINTERS
 */
public class TripletSumCloseToTarget {

    /**
     * Time:  O(nlogn) + O(n^2) = O(n^2)
     * Space: O(n) this is the space needed to sort
     */
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (end > start) {
                int cDiff = targetSum - arr[i] - arr[start] - arr[end];
                if (cDiff == 0) {
                    return targetSum; // targetSum - cDiff
                }
                if (Math.abs(cDiff) < Math.abs(smallestDiff)
                        || Math.abs(cDiff) == Math.abs(smallestDiff) && cDiff > smallestDiff) {
                    smallestDiff = cDiff;
                }
                if (cDiff < 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return targetSum - smallestDiff;
    }
}
