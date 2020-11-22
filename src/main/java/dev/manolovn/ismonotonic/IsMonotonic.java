package dev.manolovn.ismonotonic;

/**
 * source: https://leetcode.com/problems/monotonic-array/
 * difficulty: EASY
 * topics: ARRAYS
 */
public class IsMonotonic {

    /*
    #1: full traverse
    t: O(n)
    s: O(1)

    [1,2,3]
    [ 1 1 1 1 1 1 6 7]

    */
    public boolean isMonotonic(int[] A) {
        // infer direction
        boolean isAsc = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                break;
            } else if (A[i] < A[i - 1]) {
                isAsc = false;
                break;
            }
        }
        // check if the direction is correct
        for (int i = 1; i < A.length; i++) {
            if (isAsc) {
                if (A[i] < A[i - 1]) return false;
            } else {
                // is desc
                if (A[i] > A[i - 1]) return false;
            }
        }
        return true;
    }

    /**
     * alternative solution
     * Time:  O(n)
     * Space: O(1)
     */
    public boolean isMonotonic_alt(int[] A) {
        boolean dec = true;
        boolean asc = true;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) asc = false;
            if (A[i - 1] < A[i]) dec = false;
        }

        return dec || asc;
    }
}
