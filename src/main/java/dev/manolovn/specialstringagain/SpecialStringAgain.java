package dev.manolovn.specialstringagain;

/**
 * source: https://www.hackerrank.com/challenges/special-palindrome-again/problem
 * difficulty: MEDIUM
 * topics: STRINGS + PALINDROME + TRIANGULAR NUMBER
 * reference: https://en.wikipedia.org/wiki/Triangular_number
 */
public class SpecialStringAgain {

    static long substrCount(int n, String s) {
        int count = s.length();

        for (int i = 0; i < s.length(); i++) {
            // special strings that are repetitive
            int r = 0;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                r++;
                i++;
            }
            count += (r * (r + 1) / 2); // triangular numbers formula

            // special strings that are mirrored
            int p = 1;
            while (i - p >= 0 && i + p < s.length()
                    && s.charAt(i + p) == s.charAt(i - 1)
                    && s.charAt(i - p) == s.charAt(i - 1)) {
                count++;
                p++;
            }
        }

        return count;
    }
}
