package dev.manolovn.toeplitzmatrix;

public class ToeplitzMatrix {

    /*
      [1,2,3,4]
      [5,1,2,3]
      [6,5,1,2]
      true

      [1,2,3,4]
      [5,1,9,3]
      [6,5,1,2]
      false

      [1,5,3,4]
      [5,1,5,3]
      [6,5,1,5]
      true

      1. traverse the matrix
        for rows
          row[i][j] == row[i+1][j+1]
      time: O(n*m)
      space: O(1)
    */
    static boolean isToeplitz(int[][] m) {
        if (m.length == 0) {
            return false;
        }

        if (m.length == 1) {
            return true;
        }

        for (int i = 0; i < m[0].length; i++) {
            if (!check(m, 0, i)) {
                return false;
            }
        }

        for (int i = 1; i < m.length; i++) {
            if (!check(m, i, 0)) {
                return false;
            }
        }

        return true;
    }

    private static boolean check(int[][] m, int i, int j) {
        int res = m[i][j];
        while (i < m.length && j < m[0].length) {
            if (m[i][j] != res) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    /**
     * More compact alternative approach
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
        return true;
    }
}
