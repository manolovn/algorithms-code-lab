package dev.manolovn.sum;

/**
 * source: https://leetcode.com/problems/sum-of-two-integers/
 * difficulty: MEDIUM
 * topic: BIT MANIPULATION + XOR
 */
public class SumTwoIntegers {

    /**
     * For example, we want to sum a = 1 and b = 3
     * a is 1 (0001) and b is 3 (0011):
     *
     * We need to repeat this steps until a becomes != 0
     *  1. calculate the carry with &
     *      0001 & 0011 = 0001
     *  2. get differente bits with ^ (xor) and assign to b
     *      b = 0001 ^ 0011 = 0010
     *  3. right shift of the carry and assign to a
     *      a = 0001 << 1 = 0010
     */
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (a != 0) {
            int carry = a & b;
            b = a ^ b;
            a = carry << 1;
        }

        return b;
    }
}
