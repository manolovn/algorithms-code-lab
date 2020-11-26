package dev.manolovn.repeatedsubstringpattern;

/**
 * source: https://leetcode.com/problems/repeated-substring-pattern/
 * difficulty: EASY MEDIUM
 * topic: STRINGS
 */
public class RepeatedSubstringPattern {

    /**
     * KMP based solution
     * Time:  O(n)
     * Space: O(n)
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int i = 1;
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i] = j + 1;
                i++;
                j++;
            } else if (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = dp[j - 1];
            } else {
                i++;
            }
        }

        int patternLen = s.length() - dp[n - 1];
        return dp[n - 1] != 0 && s.length() % patternLen == 0;
    }

    /**
     * Simple solution using substring
     * Time:  O(n)
     * Space: O(n)
     */
    public boolean repeatedSubstringPattern_simple(String str) {
        int n = str.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                int repeat = n / i;
                String pat = str.substring(0, i); // s:O(n)
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < repeat; j++)
                    sb.append(pat); // t:O(1)
                if (sb.toString().equals(str)) return true;
            }
        }
        return false;
    }
}
