package dev.manolovn.wordbreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/word-break/
 * difficulty: MEDIUM
 * topic: RECURSION + BFS + DYNAMIC PROGRAMMING
 */
public class WordBreak {

    /*
    Reading carefully the problem statement, you could consider that the problem could be divided into some
    small subproblems like:
    starting from "leetcode" ; dict = [leet, code]
        - try to find any of the words of dict in "leetcode"
            - [case we found leet] try to find any of the words of dict in "code"

    #1: brute force with a recursive approach
    time:  O(n^n)
    space: O(n) due to recursion stack
    ---
    (#2): dp top-down with memoization
    time:  O(n^3)
    space: O(n) due to recursion stack
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
    }

    private boolean helper(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) // O(n) due to substring
                    && helper(s, end, dict, memo)) {
                return memo[start] = true;
            }
        } // O(n^2)

        return memo[start] = false;
    }
}
