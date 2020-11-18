package dev.manolovn.atoi;

/**
 * source: https://leetcode.com/problems/string-to-integer-atoi/
 * difficulty: MEDIUM
 * topics: ARRAYS
 */
public class Atoi {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        int result = 0;
        int sign = 1;
        int i = 0;

        // discard whitespaces
        while (i < s.length() && s.charAt(i) == ' ') i++;

        // extract sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }

        while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
            // check overflow
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }

        return result * sign;
    }
}
