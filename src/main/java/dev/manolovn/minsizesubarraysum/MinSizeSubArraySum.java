package dev.manolovn.minsizesubarraysum;

/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 *
 * Example:
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2]
 *
 * Difficulty: EASY
 * Topics: ARRAYS + SLIDING WINDOW
 */
public class MinSizeSubArraySum {

    /**
     * The approach is to use an sliding window
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public static int findMinSubArray(int S, int[] arr) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum >= S) {
                result = Math.min(result, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
