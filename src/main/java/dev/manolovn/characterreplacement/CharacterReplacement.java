package dev.manolovn.characterreplacement;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * Example:
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 *
 * Difficulty: HARD
 * Topics: STRINGS + SLIDING WINDOW
 */
public class CharacterReplacement {

    /**
     * Time:  O(n)
     * Space: O(1) ; due to the input is with a limited charset size
     */
    public static int findLength(String str, int k) {
        int result = 0;
        int start = 0;
        int maxRep = 0;
        Map<Character, Integer> fMap = new HashMap<>();
        for(int end = 0; end < str.length(); end++) {
            char r = str.charAt(end);
            fMap.put(r, fMap.getOrDefault(r, 0) + 1);
            maxRep = Math.max(maxRep, fMap.get(r));
            if (end - start + 1 - maxRep > k) {
                char l = str.charAt(start);
                fMap.put(l, fMap.get(l) - 1);
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
