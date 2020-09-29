package dev.manolovn.stringmatching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/string-matching-in-an-array/
 * difficulty: EASY
 * topics: STRING + STRING MATCHING + KMP
 */
public class StringMatchingInArray {

    /*
    #1: brute force
    Time:  O(n^2) + O(n) --> iterate over all words + detect substring
    Space: O(n)
    ##: detect substring
    ##1: KMP : O(n)
    ##2: naive : O(nm)
    */
    public List<String> stringMatching(String[] words) {
        Set<String> sol = new HashSet<>();
        for (int j = 0; j < words.length; j++) {
            for (int i = 0; i < words.length; i++) {
                if (j==i) continue;
                if (isSubstring(words[j], words[i])) {
                    sol.add(words[i]);
                }
            }
        }
        return new ArrayList<>(sol);
    }

    /**
     * Detect if i is a substring in j
     * Approach based on naive implementation
     * TODO: use KMP to solve
     */
    private boolean isSubstring(String text, String pattern) {
        if (pattern.length() >= text.length()) return false;

        int tl = text.length();
        int pl = pattern.length();
        int i = 0;

        while (i <= tl - pl) {
            for (int j = 0; j < pl; j++) {
                if (text.charAt(i+j) != pattern.charAt(j)) {
                    break;
                }
                if (j == pl-1) {
                    return true;
                }
            }
            i++;
        }

        return false;
    }
}
