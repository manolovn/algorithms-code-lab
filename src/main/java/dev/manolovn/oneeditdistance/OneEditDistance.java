package dev.manolovn.oneeditdistance;

/**
 * source: https://leetcode.com/problems/one-edit-distance/
 * difficulty: MEDIUM
 * topic: STRINGS
 */
public class OneEditDistance {

    /**
     * Time:  O(n) ; where n is the characters in longest string
     * Space: O(n) ; due to substring
     * In java Strings are immutables and substring method needs to create
     * a new String when is called.
     */
    public boolean isOneEditDistance(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl > tl) return isOneEditDistance(t, s); // to ensure s is smaller
        if (tl - sl > 1) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sl == tl) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        return (tl - sl) == 1;
    }
}
