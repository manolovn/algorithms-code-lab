package dev.manolovn.longestsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * difficulty: MEDIUM
 * topic: ARRAYS + STRING
 */
public class LenghtOfLongestSubstring {

    /**
     * Time:  O(n)
     * Space: O(n) ; this could be constant if we know
     *               the string charset;
     *                  26 to characters a-zA-Z
     *                  128 to ASCII
     *                  256 to ASCII extended
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return max;
    }

    /**
     * Knowing the current charset of s, we could transform the map
     * to a table with the fixed size of the character, so we reduce
     * the space complexity to O(1)
     */
    public int lengthOfLongestSubstring_withConstantSpace(String s) {
        if (s.isEmpty()) return 0;
        int[] map = new int[128];
        int max = 0;
        for (int j = 0, i = 0; j < s.length(); j++) {
            i = Math.max(i, map[s.charAt(j)]);
            max = Math.max(max, j - i + 1);
            map[s.charAt(j)] = j + 1;
        }
        return max;
    }

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public int lengthOfLongestSubstring_easier(String s) {
        if (s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, j - i);
                j++;
            } else {
                set.add(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
