package dev.manolovn.arrayleftrotation;

/**
 * source: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */
public class ArrayLeftRotation {

    /**
     * Time: O(dn) = O(n)
     * Space: O(n)
     */
    static int[] rotLeft(int[] a, int d) {
        int N = a.length;
        int[] sol = new int[N];
        for (int i = 0; i < N; i++) {
            if (i - d >= 0) {
                sol[i - d] = a[i];
            } else {
                sol[i - d + N] = a[i];
            }
        }
        return sol;
    }
}
