package dev.manolovn.deletiondistance;

public class DeletionDistance {

    /*
      "dog"

      "frog" ; d = 3
      -f
      -r
      d

      str1: atbd
      str2: batd

      P(atbd, batd) = min(P(tbd, batd) + P(atbd, atd) + ...)
      O(str1 * str2)

      solve(x, y) {
        if (x[0] == y[0]) {
          return 0 + solve(x[1:], y[1:])
        } else {
          left = solve(x[1:], y)
          right = solve(x, y[1:])
          return min(left, right)
        }
      }

      s: ""
      t: "asdfdsaf"

      calculate words that are not in str2
      + calculate words that are not in str1
    */
    static int deletionDistance(String s, String t) {
        String[][] memo = new String[s.length()][t.length()];
        return dp(s, t, memo);
    }

    static int dp(String s, String t, String[][] memo) {
        if (s.length() == 0) {
            return t.length();
        }
        if (t.length() == 0) {
            return s.length();
        }
        if (s.length() <= 0 || t.length() <= 0) {
            return 0;
        }

        // check memo
        if (s.charAt(0) == t.charAt(0)) {
            // add to memo
            return deletionDistance(s.substring(1), t.substring(1));
        } else {
            int l = deletionDistance(s.substring(1), t);
            int r = deletionDistance(s, t.substring(1));
            // add memo
            return Math.min(l, r) + 1;
        }
    }
}
