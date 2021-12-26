package dev.manolovn.tictactoe;

/**
 * source: https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game
 * difficulty: EASY
 * topic: ARRAY
 */
public class TicTacToe {

    /**
     * There are only 8 ways to win for every player:
     * <p>
     * 0: 1st row
     * 1: 2nd row
     * 2: 3rd row
     * 3: 1st col
     * 4: 2nd col
     * 5: 3rd col
     * 6: diagonal top left -> bottom right
     * 7: diagonal top right -> bottom left
     */
    public String tictactoe(int[][] moves) {
        int[] A = new int[8];
        int[] B = new int[8];

        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            int[] player = (i % 2 == 0) ? A : B;

            player[row]++;
            player[col + 3]++;
            if (row == col) player[6]++;
            if (row == 2 - col) player[7]++;
        }

        for (int i = 0; i < 8; i++) {
            if (A[i] == 3) return "A";
            if (B[i] == 3) return "B";
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
