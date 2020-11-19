package dev.manolovn.reverseinteger;

/**
 * source: https://leetcode.com/problems/reverse-integer/
 * difficulty: EASY
 * topic: MATH
 */
public class ReverseInteger {

    /*
    t: O(n) ; where n is the length of x = O(log10(x))
    s: O(1)
    */
    public int reverse(int x) {
        int n = 0;
        while (x != 0) {
            int tmp = n;
            int d = x % 10;
            x /= 10;
            n = n * 10 + d;
            if (tmp != (n - d) / 10) return 0;
        }
        return n;
    }
}
