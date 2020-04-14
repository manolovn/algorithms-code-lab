package dev.manolovn.basicregexparser;

public class BasicRegexParser {

    static boolean isMatch(String text, String pattern) {
        return helper(text, 0, pattern, 0);
    }

    static boolean helper(String t, int ti, String p, int pi) {
        // t and p scans are finished
        if (t.length() <= ti) {
            if (p.length() <= pi) {
                return true;
            } else {
                if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                    return helper(t, ti, p, pi + 2);
                } else {
                    return false;
                }
            }
        } else if (pi >= p.length() && ti < t.length()) {
            return false;
            // text matching with char followed by *
        } else if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
            if (p.charAt(pi) == '.' || t.charAt(ti) == p.charAt(ti)) {
                return helper(t, ti, p, pi + 2) || helper(t, ti + 1, p, pi);
            } else {
                return helper(t, ti, p, pi + 2);
            }
            // found a . or characters equals
        } else if (p.charAt(pi) == '.' || t.charAt(ti) == p.charAt(pi)) {
            return helper(t, ti + 1, p, pi + 1);
        } else {
            return false;
        }
    }
}
