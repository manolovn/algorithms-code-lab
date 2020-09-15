package dev.manolovn.alternatingcharacters;

/**
 * source: https://www.hackerrank.com/challenges/alternating-characters/problem
 * difficulty: EASY
 * topic: STRINGS
 */
public class AlternatingCharacters {

    /**
     * Time:  O(n) ; we need only to traverse the input string once
     * Space: O(1) ; we don't need memory that depends of the input
     */
    static int alternatingCharacters(String s) {
        int dels = 0;
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                dels += count - 1;
                count = 1;
                continue;
            }
            count++;
        }

        dels += count - 1;;
        return dels;
    }
}
