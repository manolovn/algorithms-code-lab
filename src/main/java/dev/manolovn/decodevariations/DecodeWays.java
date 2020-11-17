package dev.manolovn.decodevariations;

/**
 * source: https://leetcode.com/problems/decode-ways/
 * difficulty: MEDIUM
 * topic: DP
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }

            int num = ((s.charAt(i-2) - '0') * 10) + (s.charAt(i-1) - '0');
            if (num <= 26 && num >= 10) {
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }
}
