package dev.manolovn.reversestring;

/**
 * source: https://leetcode.com/problems/reverse-string/
 * difficulty: EASY
 * topic: STRINGS
 */
public class ReverseString {

    /**
     * Time:  O(n)
     * Space: O(1)
     * Using two pointers we could reverse the string in place
     * swapping the characters from every pointer
     */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;

            l++;
            r--;
        }
    }
}
