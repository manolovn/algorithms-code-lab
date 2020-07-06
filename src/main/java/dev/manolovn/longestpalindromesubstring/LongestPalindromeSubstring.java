package dev.manolovn.longestpalindromesubstring;

/**
 * source: https://leetcode.com/problems/longest-palindromic-substring/
 * difficulty: MEDIUM
 */
public class LongestPalindromeSubstring {

    /**
     * The idea is taking into account that a palindrome has a center where the word is mirrored,
     * so we traverse every character in the input string guessing that it the center of the palindrome
     *
     * Time:  O(n^2) ; we are repeating mirror function call on every char and mirror could take O(n)
     * Space: O(1)
     *
     * EXTRA: to improve this solution take a took to
     * Manacher's Algorithm (https://en.wikipedia.org/wiki/Longest_palindromic_substring#Manacher's_algorithm)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return ""; // no palindrome possible
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(
                    mirror(s, i, i),
                    mirror(s, i, i + 1)
            );
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int mirror(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
