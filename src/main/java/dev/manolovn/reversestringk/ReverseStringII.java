package dev.manolovn.reversestringk;

/**
 * source: https://leetcode.com/problems/reverse-string-ii/
 * difficulty: EASY
 * topic: ARRAYS + STRING
 */
public class ReverseStringII {

    /*
    Time:  O(n)
    Space: O(n)
    */
    public String reverseStr(String s, int k) {
        int i = 0;
        char[] ca = s.toCharArray();
        while (i < s.length()) {
            // reverse chars
            reverseKChars(ca, i, Math.min(i+k-1, s.length()-1));
            i += 2*k;
        }
        return new String(ca);
    }

    private void reverseKChars(char[] ca, int from, int to) {
        while (from <= to) {
            char aux = ca[from];
            ca[from++] = ca[to];
            ca[to--] = aux;
        }
    }
}
