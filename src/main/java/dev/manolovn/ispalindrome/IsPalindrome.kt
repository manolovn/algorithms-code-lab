package dev.manolovn.ispalindrome

/**
 * source: https://leetcode.com/problems/valid-palindrome/
 * difficulty: EASY
 * topics: STRINGS + PALINDROME
 */
class IsPalindrome {
    /**
     * Time:  O(n)
     * Space: O(1)
     */
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            while (!Character.isLetterOrDigit(s[i])
                && i < j) i++
            while (!Character.isLetterOrDigit(s[j])
                && i < j) j--
            if (i < j && Character.toLowerCase(s[i]) != Character.toLowerCase(s[j])) {
                return false
            }
            i++
            j--
        }
        return true
    }
}