package dev.manolovn.replacingones;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 * <p>
 * Example:
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * <p>
 * Difficulty: HARD
 * Topics: ARRAYS + SLIDING WINDOW
 */
public class ReplacingOnes {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static int findLength(int[] arr, int k) {
        int result = 0;
        int maxRep = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 1) {
                maxRep++;
            }
            if (end - start + 1 - maxRep > k) {
                if (arr[start] == 1) {
                    maxRep--;
                }
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
