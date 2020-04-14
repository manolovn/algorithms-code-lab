package dev.manolovn.decodevariations;

public class DecodeVariations {

    static int decodeVariations(String S) {
        int len = S.length();
        int[] memo = new int[len + 1];
        // TODO: add memoization
        return dp(S, len);
    }

    private static int dp(String s, int l) {
        if (l == 0) {
            return 1;
        }
        int k = s.length() - l;
        if (s.charAt(k) == '0') {
            return 0;
        }

        int result = dp(s, l - 1);
        if (l >= 2 && Integer.parseInt(s.substring(k, k + 2)) <= 26) {
            result += dp(s, l - 2);
        }
        return result;
    }
}
