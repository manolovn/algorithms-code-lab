package dev.manolovn.validpalindrome;

/**
 * source: https://leetcode.com/problems/valid-palindrome-ii/
 * difficulty: EASY
 * topics: STRINGS
 */
public class ValidPalindromeII {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return validPalindromeRange(s, l + 1, r) || validPalindromeRange(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean validPalindromeRange(String s, int from, int to) {
        while (from <= to) {
            if (s.charAt(from) != s.charAt(to)) {
                return false;
            }
            from++;
            to--;
        }
        return true;
    }
}
