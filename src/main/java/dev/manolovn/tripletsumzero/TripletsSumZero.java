package dev.manolovn.tripletsumzero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * <p>
 * Example:
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero
 * <p>
 * Difficulty: MEDIUM
 * Topics: ARRAYS + TWO POINTERS
 */
public class TripletsSumZero {

    /**
     * Time: O(nlogn) + O(n^2) = O(n^2) ; O(nlogn) is due to the array sort
     * Space: O(n)
     */
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr); // sort the input; O(nlogn)
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            searchPair(arr, i + 1, -arr[i], triplets); // O(n)
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int start, int target, List<List<Integer>> triplets) {
        int end = arr.length - 1;
        while (end > start) {
            int currentSum = arr[end] + arr[start];
            if (currentSum == target) {
                triplets.add(Arrays.asList(-target, arr[start], arr[end]));
                end--;
                start++;
                while (start < end && arr[start] == arr[start - 1]) {
                    start++; // to skip equal numbers to avoid duplicates
                }
                while (start < end && arr[end] == arr[end + 1]) {
                    end--; // to skip equal numbers to avoid duplicates
                }
            } else if (currentSum > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
