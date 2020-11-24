package dev.manolovn.longestsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * difficulty: MEDIUM
 * topic: ARRAYS + STRING
 */
public class LenghtOfLongestSubstring {

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
}
