package dev.manolovn.singlenumber;

/**
 * In a non-empty array of integers, every number appears twice except for one, find that single number
 * Example:
 * Input: 1, 4, 2, 1, 3, 2, 3
 * Output: 4
 *
 * difficulty: EASY
 * topics: XOR
 */
public class SingleNumber {

    /**
     * An approach is just to use a HashMap and obtain a complexity of O(n) in space and time;
     * but using an XOR approach we'll obtain:
     * Time:  O(n)
     * Space: O(1)
     */
    public static int findSingleNumber(int[] arr) {
        int num = 0;
        for (int j : arr) {
            num ^= j;
        }
        return num;
    }
}
