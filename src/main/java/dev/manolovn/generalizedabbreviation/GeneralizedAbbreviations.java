package dev.manolovn.generalizedabbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a word, write a function to generate all of its unique generalized abbreviations
 * Example:
 * Input: "BAT"
 * Output: "BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3"
 *
 * difficulty: hard
 * topcis: RECURSION + PERMUTATION
 */
public class GeneralizedAbbreviations {

    /**
     * Time:  O(n2^n)
     * Space: O(n2^n)
     */
    public List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<>();
        rec(0, 0, "", word.toCharArray(), result);
        return result;
    }

    private void rec(int idx, int digit, String curr, char[] word, List<String> result) {
        if (idx == word.length) {
            if (digit != 0) {
                curr += digit;
            }
            result.add(curr);
            return;
        }
        rec(idx + 1, digit + 1, curr, word, result);
        if (digit != 0) {
            curr += digit;
        }
        rec(idx + 1, 0, curr + word[idx], word, result);
    }
}
