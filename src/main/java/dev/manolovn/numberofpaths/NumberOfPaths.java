package dev.manolovn.numberofpaths;

public class NumberOfPaths {

    /*
        time = O(n^2)
        space = O(n)
        n x n
        i >= j

        (square matrix)
         i-
        j  [ ][ ][e]
        |  [ ][x][x]
           [s][x][x]
        output : 2

        dp : [1][1][2]

        p(O,O) = p(1,0) + p(1,1) + p(2,1) + p(2,2)
    */

    // TODO: try with a recursion tree
    static int numOfPathsToDest(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
