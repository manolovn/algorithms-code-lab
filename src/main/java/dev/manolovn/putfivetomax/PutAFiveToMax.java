package dev.manolovn.putfivetomax;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

/**
 * HIGH FIVE:
 * Given a number N, put a 5 in a position to obtain the maximum number possible:
 * No matter performance, just focus on completeness
 * <p>
 * Example:
 * N: 289 ; output: 5289
 * N: 999 ; output: 9995
 * N: 732 ; output: 7532
 * N: 0   ; output: 50
 * N: -99 ; output: -599
 */
public class PutAFiveToMax {

    public static int putAFive(int N) {
        String input = String.valueOf(N);
        int len = input.length();
        int solution = Integer.MIN_VALUE;
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i <= len; i++) {
            if (i < len && input.charAt(i) == '-') {
                buf.append(input.charAt(i));
                i++;
            }
            solution = max(solution, parseInt(buf.toString() + 5 + input.substring(i)));
            if (i < len) {
                buf.append(input.charAt(i));
            }
        }

        return solution;
    }
}
