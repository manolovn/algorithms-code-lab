package dev.manolovn.diffbetweentwostrings;

/**
 * Diff between two strings
 * ------------------------
 * Given two strings of uppercase letters source and target, list (in string form) a sequence of edits to convert
 * from source to target that uses the least edits possible.
 *
 * For example, with strings source = "ABCDEFG", and target = "ABDFFGH"
 * we might return: ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"
 *
 * If there are multiple answers, use the answer that favors removing from the source first.
 */
public class DiffBetweenTwoStrings {

    static String[] diffBetweenTwoStrings(String source, String target) {
        String solution = dp(source, target);
        return solution.split(" ");
    }

    private static String dp(String source, String target) {
        if (source.length() <= 0 || target.length() <= 0) {
            return source;
        }

        if (source.charAt(0) == target.charAt(0)) {
            return source.charAt(0) + " " + dp(source.substring(1), target.substring(1));
        } else {
            String ans1 = dp(source.substring(1), target);
            String ans2 = dp(source, target.substring(1));
            if (ans1.length() <= ans2.length()) {
                return "-" + source.charAt(0) + " " + ans1;
            }
            return "+" + target.charAt(0) + " " + ans2;
        }
    }
}
