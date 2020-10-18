package dev.manolovn.maxsumsubarray;

/**
 * Given an array of positive numbers and a positive number k,
 * find the maximum sum of any contiguous subarray of size k
 *
 * Example:
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: maximum sum is [5, 1, 3].
 */
public class MaxSumSubarray {

    /*
        The idea is to follow a sliding window approach
        keeping the max value as the possible result
        Time:  O(n)
        Space: O(1)
    */
    public static int findMaxSumSubArray(int k, int[] arr) {
        int result = 0;

        int sum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            if (end >= k-1) {
                result = Math.max(sum, result);
                sum -= arr[start];
                start++;
            }
        }

        return result;
    }
}
