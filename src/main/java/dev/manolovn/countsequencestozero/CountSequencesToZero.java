package dev.manolovn.countsequencestozero;

/**
 * Write a function that, given an array A consisting of N integers, returns the number of fragments of A whose
 * sum equals 0 (that is, pairs (P,Q) such that P<=Q and the sum A[P] + A[P+1] + ... + A[Q] is 0)
 * The function should return -1 if this number exceeds 1,000,000,000
 *
 * Examples:
 * 1. Given A=[2,-2,3,0,4,-7], the function should return 4:
 *      2  -2  3  0  4  -7
 *      -----     -
 *             -----------
 *      ------------------
 *  2. Given A=[0,0,...0] of length 100,000 the function should return -1
 *
 *  Write an efficient algorithm for the following assumptions:
 *  - N is an integer within the range [1..100,000]
 *  - each element of array A is an integer within the range [-10,000...10,000]
 */
public class CountSequencesToZero {

    /**
     *
     */
    public static int sequenceCountToZero(int[] A) {
        int[] dp = new int[A.length-1];
        dp[0] = A[0];
        return recursive(A, 1, dp, 0, 0);
    }

    private static int recursive(int[] A, int idx, int[] dp, int jdx, int count) {
        if (idx >= A.length) return count;
        if (A[idx] == 0) count += 1;
        for (int i = 0; i <= jdx; i++) {
            if (A[idx] + dp[i] == 0) count += 1;
            if (i == jdx) {
                dp[jdx++] = dp[i] + A[idx];
                break;
            }
        }
        return recursive(A, idx + 1, dp, jdx, count);
    }

    public static void main(String[] args) {
        System.out.println(sequenceCountToZero(new int[]{2, -2, 3, 0, 4, -7}));
    }
}
