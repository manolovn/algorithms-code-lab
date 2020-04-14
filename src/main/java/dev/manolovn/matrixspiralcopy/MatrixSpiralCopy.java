package dev.manolovn.matrixspiralcopy;

public class MatrixSpiralCopy {

    /*
       [1,    2,   3,  4,    5]
       [6,    7,   8,  9,   10]
       [11,  12,  13,  14,  15]
       [16,  17,  18,  19,  20]

       t: O(n*m)
       s: O(n*m)
    */
    static int[] spiralCopy(int[][] inputMatrix) {
        int n = inputMatrix.length; // rows
        int m = inputMatrix[0].length; // cols

        if (n == 1) {
            return inputMatrix[0];
        }

        int[] flat = new int[n * m];

        int firstCol = 0;
        int firstRow = 0;
        int lastCol = m - 1;
        int lastRow = n - 1;

        int idx = 0;

        while (firstCol <= lastCol && firstRow <= lastRow) {
            // top side
            for (int j = firstCol; j <= lastCol; j++) {
                flat[idx] = inputMatrix[firstRow][j];
                idx++;
            }
            firstRow++;

            // right side
            for (int j = firstRow; j <= lastRow; j++) {
                flat[idx] = inputMatrix[j][lastCol];
                idx++;
            }
            lastCol--;

            // bottom side
            for (int j = lastCol; j >= firstCol; j--) {
                flat[idx] = inputMatrix[lastRow][j];
                idx++;
            }
            lastRow--;

            // left side
            for (int j = lastRow; j >= firstRow; j--) {
                flat[idx] = inputMatrix[j][firstCol];
                idx++;
            }
            firstCol++;
        }

        return flat;
    }
}
