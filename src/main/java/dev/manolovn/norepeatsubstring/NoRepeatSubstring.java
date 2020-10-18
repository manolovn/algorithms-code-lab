package dev.manolovn.norepeatsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring which has no repeating characters.
 *
 * Example:
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc"
 *
 * Difficulty: HARD
 * Topics: STRINGS + SLIDING WINDOW
 */
public class NoRepeatSubstring {

    /**
     * Time:  O(n)
     * Space: O(k) ; where k is the number of different characters in str
     * Taking into account the input charset, we could create a fixed size structure.
     * For example, if the input only contains 26 characters we could create a bitmask or a simply
     * array where the index means the ASCII character.
     */
    public static int findLength(String str) {
        int result = 0;
        int start = 0;
        Map<Character, Integer> idxMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char r = str.charAt(end);
            if (idxMap.containsKey(r)) {
                start = Math.max(end, idxMap.get(r) + 1);
            }
            idxMap.put(r, end);
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
