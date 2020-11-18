package dev.manolovn.validanagram;

/**
 * source: https://leetcode.com/problems/valid-anagram/
 * difficulty: MEDIUM
 * topic: ARRAYS
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (int j : map)
            if (j != 0) return false;

        return true;
    }
}
