package dev.manolovn.powx;

/**
 * source: https://leetcode.com/problems/powx-n/
 * difficulty: MEDIUM
 * topic: MATH
 */
public class PowXN {

    /**
     * Time:  O(logn)
     * Space: O(1)
     */
    public double myPow(double x, int N) {
        long n = N;
        if (n == 0) return 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double res = 1;
        double curr = x;
        for (long i = n; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                res *= curr;
            }
            curr *= curr;
        }
        return res;
    }
}
