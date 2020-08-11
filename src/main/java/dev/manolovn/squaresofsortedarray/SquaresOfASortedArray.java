package dev.manolovn.squaresofsortedarray;

/**
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * Example:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * <p>
 * Source: https://leetcode.com/problems/squares-of-a-sorted-array/
 * Difficulty: EASY
 */
public class SquaresOfASortedArray {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public int[] sortedSquares(int[] A) {
        if (A == null) {
            return null;
        }

        int[] solution = new int[A.length];
        int head = 0;
        int tail = A.length - 1;
        int i = tail;
        while (head <= tail) {
            int hPow = A[head] * A[head];
            int tPow = A[tail] * A[tail];
            if (hPow > tPow) {
                solution[i--] = hPow;
                head++;
            } else {
                solution[i--] = tPow;
                tail--;
            }
        }
        return solution;
    }
}
