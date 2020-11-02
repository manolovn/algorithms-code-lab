package dev.manolovn.calculatecomplement;

/**
 * For a given positive number N in base-10, return the complement of its binary representation as a base-10 integer.
 * <p>
 * Example:
 * Input: 8
 * Output: 7
 * Explanation: 8 is 1000 in binary, its complement is 0111 in binary, which is 7 in base-10
 * <p>
 * difficulty: MEDIUM
 * topics: BITWISE XOR
 */
public class CalculateComplement {

    /**
     * Time:  O(
     * Space: O(1)
     */
    public static int bitwiseComplement(int n) {
        int num = n;
        // count bits in `n`
        int bitCount = 0;
        while (n > 0) {
            n = n >> 1;
            bitCount++;
        }
        // create a "mask" with all one with bitCount size
        int mask = (int) (Math.pow(2, bitCount) - 1);
        // our number XOR mask is the solution
        // for example; with 8(1000) ^ mask = 2^4 - 1 = 15(1111) -> solution is 7(0111)
        return num ^ mask;
    }
}
