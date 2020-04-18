package dev.manolovn.abbreviation

object Abbreviation {

    /*
        source: daBcd
        target: ABC
        => p(daBcd, ABC) = p(daBcd, ABC) & p(aBcd, ABC) & p(Bcd, BC) & p(cd, C) & p(d,_)

        Reviewing the example case, we could notice that the problem could be divided into a composition of
        smaller problems that are the same that the main one. This is a a nice clue that the solution is related
        with dynamic programming techniques.

        Allowed ops to convert the input:
        - capitalize a character
        - remove a lowercase character

        Thinking about the two principal dynamic programming implementations:
        1. recursive approach top-down + memoization
            fun solve(a,b)
                if (a.length <= 0) {
                    if (b.length <= 0 || b[0:].isLowerCase) {
                        return true
                    } else {
                        return false
                    }
                }
                if (a[0] == b[0]) { // case when can capitalize
                    return true || solve(a[1:], b[1:])
                } else if(a[0].isLowerCase) { // case when remove character
                    return true || solve(a[1:],b)
                } else {
                    return false
                }
           (memoization is no included in the pseudocode)
        2. dp approach bottom-up
            finally implemented thinking in simplicity.
            The implementation consist into of feeding a two-dimensional matrix that represents
            all possible subproblems that make up the initial problem.

        space and time O(N*M) N and M are the lengths of a and b
    */
    fun abbreviation(a: String, b: String): String {
        val n = a.length
        val m = b.length
        val dp = Array(n + 1) { IntArray(m + 1) }
        dp[0][0] = 1
        for (i in 0 until n) {
            for (j in 0 until m + 1) {
                if (dp[i][j] == 0) {
                    continue
                }
                if (j < m && a[i].toUpperCase() == b[j]) { // case when can capitalize
                    dp[i + 1][j + 1] = 1
                }
                if (a[i].isLowerCase()) { // case when remove character
                    dp[i + 1][j] = 1
                }
            }
        }
        return if (dp[n][m] != 0) "YES" else "NO"
    }
}