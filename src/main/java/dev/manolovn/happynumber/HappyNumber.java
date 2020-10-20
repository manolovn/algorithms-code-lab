package dev.manolovn.happynumber;

import java.util.HashSet;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/happy-number/
 * difficulty: EASY
 */
public class HappyNumber {

    /**
     * In this brute force approach we use an approach with a Set as "memory" of the previous calculations
     * The final result in complexity terms is:
     *
     * Time:  O(n) ; where "n" is the number of steps needed to calculate the happy number or the length of the
     *               cycle when the number is not happy
     * Space: O(n)
     */
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
