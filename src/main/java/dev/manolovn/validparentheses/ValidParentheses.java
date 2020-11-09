package dev.manolovn.validparentheses;

import java.util.*;

/**
 * source: https://leetcode.com/problems/valid-parentheses/
 * difficulty: EASY
 * topics: ARRAYS + STACK
 */
public class ValidParentheses {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else if (map.containsValue(c)) {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
