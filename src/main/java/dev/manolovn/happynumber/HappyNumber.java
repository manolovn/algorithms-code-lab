package dev.manolovn.happynumber;

import java.util.HashSet;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>(); // a set to detect cycles
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = sumOfDigits(n);
        }
        return n == 1;
    }

    /**
     * Helper function to calculate the sum of the digit squares
     */
    public int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
