package dev.manolovn.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all of its permutations preserving the character sequence but changing case
 * Example:
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52"
 *
 * difficulty: medium
 * topics: permutations
 */
public class LetterCaseStringPermutation {

    /**
     * Time:  O(n2^n)
     * Space: O(n2^n)
     * Where n is the length of the input string
     */
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int size = permutations.size();
                for (int j = 0; j < size; j++) {
                    char[] chars = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    } else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    permutations.add(new String(chars));
                }
            }
        }

        return permutations;
    }
}
