package dev.manolovn.basiccalculator;

/**
 * source: https://leetcode.com/problems/basic-calculator-ii/
 * difficulty: MEDIUM
 * topic: ARRAY + MATH
 */
public class BasicCalculator {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        int curr = 0;
        int prev = 0;
        int result = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if (operator == '+') {
                    result += prev;
                    prev = curr;
                }
                if (operator == '-') {
                    result += prev;
                    prev = -curr;
                }
                if (operator == '*') {
                    prev = prev * curr;
                }
                if (operator == '/') {
                    prev = prev / curr;
                }
                operator = c;
                curr = 0;
            }
        }
        result += prev;
        return result;
    }
}
