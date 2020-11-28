package dev.manolovn.firstuniquechar;

/**
 * source: https://leetcode.com/problems/first-unique-character-in-a-string/
 * difficulty: EASY
 * topic: ARRAY
 */
public class FirstUniqueChar {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[c - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (map[s.charAt(i) - 'a'] == 1) return i;

        return -1;
    }
}
