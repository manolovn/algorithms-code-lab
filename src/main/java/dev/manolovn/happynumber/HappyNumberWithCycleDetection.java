package dev.manolovn.happynumber;

/**
 * source: https://leetcode.com/problems/happy-number/
 * difficulty: EASY
 */
public class HappyNumberWithCycleDetection {

    /**
     * Applying cycle detection knowledge we can improve the previous implementation
     *
     * Time:  O(n) ; where "n" is the number of steps needed to calculate the happy number or the length of the
     *               cycle when the number is not happy
     * Space: O(1) ; no need extra data structures
     */
    public boolean isHappy(int num) {
        int slow = num;
        int fast = num;
        while (fast != 1) {
            slow = calc(slow);
            fast = calc(calc(fast));
            if (slow == fast && slow != 1) {
                return false;
            }
        }
        return true;
    }

    private int calc(int num) {
        int result = 0;
        int digit;
        while (num > 0) {
            digit = num % 10;
            result += digit * digit;
            num /= 10;
        }
        return result;
    }
}
