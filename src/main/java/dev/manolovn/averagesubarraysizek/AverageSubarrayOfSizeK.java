package dev.manolovn.averagesubarraysizek;

import java.util.Arrays;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it
 * Difficulty: EASY
 * Topic: ARRAYS + SLIDING WINDOW
 */
public class AverageSubarrayOfSizeK {

    /**
     * The idea is to use a simple sliding window approach
     * Time:  O(n)
     * Space: O(K)
     */
    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double sum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            if (end >= K - 1) {
                result[start] = sum / K;
                sum -= arr[start];
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        double[] result = findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
