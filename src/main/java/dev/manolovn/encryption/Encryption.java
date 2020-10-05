package dev.manolovn.encryption;

/**
 * source: https://www.hackerrank.com/challenges/encryption/problem
 * difficulty: MEDIUM
 * topics: STRINGS
 */
public class Encryption {

    static final char NUL = '\u0000';

    // Complete the encryption function below.
    static String encryption(String s) {
        // 1. remove spaces
        s = s.replaceAll("\\s+", "");
        // 2. calc dimens
        double sqrt = Math.sqrt(s.length());
        int x = (int) Math.floor(sqrt);
        int y = (int) Math.ceil(sqrt);
        if ((x * y) < s.length()) {
            x = Math.max(x, y);
            y = x;
        }
        // 3 .build chars matrix
        char[][] chars = new char[x][y];
        int p = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                chars[i][j] = s.charAt(p++);
                if (p >= s.length()) break;
            }
        }
        // 4. traverse colwise matrix building output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (chars[j][i] != NUL)
                    sb.append(chars[j][i]);
            }
            if (i < y - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
