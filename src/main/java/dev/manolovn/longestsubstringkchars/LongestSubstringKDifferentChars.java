package dev.manolovn.longestsubstringkchars;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Example:
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 */
public class LongestSubstringKDifferentChars {

    /**
     * Time:  O(n)
     * Space: O(k) ; due to the frequency map size
     */
    public static int findLength(String str, int k) {
        if (str == null || str.isEmpty() || k > str.length()) {
            return 0; // not possible
        }
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> fMap = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char rc = str.charAt(end);
            fMap.put(rc, fMap.getOrDefault(rc, 0) + 1);
            while (fMap.size() > k) {
                char lc = str.charAt(start);
                fMap.put(lc, fMap.get(lc) - 1);
                if (fMap.get(lc) == 0) {
                    fMap.remove(lc);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
