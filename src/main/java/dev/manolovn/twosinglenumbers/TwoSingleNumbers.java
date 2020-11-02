package dev.manolovn.twosinglenumbers;

/**
 * In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once.
 * Find the two numbers that appear only once.
 * <p>
 * Example:
 * Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
 * Output: [4, 6]
 * <p>
 * difficulty: MEDIUM
 * topics: XOR
 */
public class TwoSingleNumbers {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static int[] findSingleNumbers(int[] nums) {
        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }

        // get the rightmost bit that is '1'
        int rightmostSetBit = 1;
        while ((rightmostSetBit & n1xn2) == 0) {
            rightmostSetBit = rightmostSetBit << 1;
        }
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) // the bit is set
                num1 ^= num;
            else // the bit is not set
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }
}
