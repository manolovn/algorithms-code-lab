package dev.manolovn.hammingdistance;

/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 2^31
 * <p>
 * Example:
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 * <p>
 * source: https://leetcode.com/problems/hamming-distance/
 * difficulty: EASY
 */
public class HammingDistance {

    /**
     * Approach with binary operators:
     * The approach is to use XOR operator and count the number of 1s exists in the result
     * Time:  O(log2(max(x,y))) ; time is the number of bits of the maximum number in the input
     * Space: O(1) ; space is constant, just an integer
     */
    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        int setBits = 0;

        while (r > 0) {
            setBits += r & 1;
            r >>= 1;
        }

        return setBits;
    }

    /**
     * 1. Integer.toBinaryString
     * 2. comparing char by char (bit by bit)
     *
     * Time:  O(1)
     * Space: O(1)
     */
    public int hammingDistance_bruteForce(int x, int y) {
        int[] binaryx = new int[31];
        int[] binaryy = new int[31];
        int index = 0;
        int diff = 0;
        while (x > 0) {
            binaryx[index++] = x % 2;
            x = x/2;
        }
        index = 0;
        while (y > 0) {
            binaryy[index++] = y % 2;
            y = y/2;
        }
        for (int i = 0; i < 31; i++) {
            if (binaryx[i] != binaryy[i]) {
                diff++;
            }
        }
        return diff;
    }
}
