package dev.manolovn.generateparenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses
 * Example:
 * Input: N=2
 * Output: (()), ()()
 *
 * difficulty: HARD
 * topics: RECURSION + BFS + PERMUTATIONS
 */
public class GenerateParenthesis {

    /**
     * Time:  O(n2^n)
     * Space: O(n2^n)
     */
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        rec(num, 0, 0, "", result);
        return result;
    }

    private static void rec(int N, int open, int close, String curr, List<String> result) {
        if (open == N && close == N) {
            result.add(curr);
            return;
        }
        // TODO: change string concatenation to another approach like StringBuilder o using the String as a char[]
        if (open < N) {
            rec(N, open + 1, close, curr + "(", result);
        }
        if (close < open) {
            rec(N, open, close + 1, curr + ")", result);
        }
    }
}
