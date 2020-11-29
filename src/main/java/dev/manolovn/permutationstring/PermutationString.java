package dev.manolovn.permutationstring;

import java.util.Arrays;

/**
 * source: https://leetcode.com/problems/permutation-in-string/
 * difficulty: MEDIUM
 * topic: ARRAY + STRING
 */
public class PermutationString {

    /*
    s1 = "ab" s2 = "eidbaooo"
                      ^^

    #1: sliding window
    t: O(n)
    s: O(n)

    #2: kmp
    */
    public boolean checkInclusion(String s1, String s2) {
        int[] s1hash = new int[26];
        for (int i = 0; i < s1.length(); i++) s1hash[s1.charAt(i) - 'a']++;

        int r = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            if (match(s1hash, s2, i, Math.min(i + r, s2.length()))) {
                return true;
            }
        }
        return false;
    }

    private boolean match(int[] s1hash, String s2, int l, int r) {
        int[] s2hash = new int[26];
        for (int i = l; i < r; i++) s2hash[s2.charAt(i) - 'a']++;
        return Arrays.equals(s1hash, s2hash);
    }
}
