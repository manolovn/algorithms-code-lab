package dev.manolovn.matrixdiagonalorder;

/**
 * source: https://leetcode.com/problems/diagonal-traverse
 * difficulty: MEDIUM
 * topics: ARRAYS
 */
public class MatrixDiagonalOrder {

    /*
    Time: O(n*m)
    Space: O(1) ; ignoring output array that is a requirement of the problem itself
    */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int n = matrix.length;
        int m = matrix[0].length;
        int[] sol = new int[m*n];

        int c = 0;
        int r = 0;

        int idx = 0;
        int dir = 1; // direction

        while (r < n && c < m) {

            sol[idx++] = matrix[r][c];

            int new_r = r + (dir == 1 ? -1 : 1); // when upwards, dec row
            int new_c = c + (dir == 1 ? 1 : -1); // when upwards, inc column

            // check if the next cell is inside the matrix limits
            if (new_r < 0 || new_r == n || new_c < 0 || new_c == m) {
                if (dir == 1) { // upwards direction
                    r += (c == m-1 ? 1 : 0);
                    c += (c < m-1 ? 1 : 0);
                } else { // downwards direction
                    c += (r == n-1 ? 1 : 0);
                    r += (r < n-1 ? 1 : 0);
                }
                // flip direction
                dir = 1-dir;
            } else {
                r = new_r;
                c = new_c;
            }
        }

        return sol;
    }
}
