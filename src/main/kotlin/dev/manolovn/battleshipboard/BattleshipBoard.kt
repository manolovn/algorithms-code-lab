package dev.manolovn.battleshipboard

object BattleshipBoard {

    /*
        Seems to be classic problem oriented to bfs but taking into account that we should not
        modify the input; a classic bfs implementation that disable the visited nodes is not enough.
        - we could use a list of visited nodes by our bfs as a blacklist, with this approach we accomplish
        the not modifying input requirement but we also need to think that space complexity must be O(1)
        - the statement says that we should do only one pass and reviewing the conditions of how the ships
        are drawn we could use a "greedy" approach where a ship is defined by a cell with "X" and neighbours
        distinct of "X". That approach is valid because the ships only could be in horizontal or vertical
        orientation.

         Time : O(N*M) ; where N and M are the dimensions of the matrix
        Space : O(1)   ; no extra data structure is needed
     */
    fun countBattleships(board: Array<CharArray>): Int {
        var shipsCount = 0

        for ((i, n) in board.withIndex()) {
            for ((j, m) in n.withIndex()) {
                if (m == 'X'
                    && (i == 0 || board[i - 1][j] != 'X')
                    && (j == 0 || board[i][j - 1] != 'X')) {
                    shipsCount++
                }
            }
        }
        return shipsCount
    }
}