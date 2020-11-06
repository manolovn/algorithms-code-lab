package dev.manolovn.ispalindrome;

/**
 * source: https://leetcode.com/problems/valid-palindrome/
 * difficulty: EASY
 * topics: STRINGS + PALINDROME
 */
public class IsPalindrome {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) i++;
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) j--;

            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
