package dev.manolovn.minremovelvalidparentheses;

/**
 * source: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * difficulty: MEDIUM
 * topic: STRINGS
 */
public class MinRemovalValidParentheses {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                balance++;
            }
            if (c == ')') {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();
        int keep = open - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                keep--;
                if (keep < 0) continue;
            }
            result.append(c);
        }

        return result.toString();
    }
}
