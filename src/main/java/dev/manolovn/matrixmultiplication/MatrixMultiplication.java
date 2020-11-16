package dev.manolovn.matrixmultiplication;

/**
 * source: https://leetcode.com/problems/sparse-matrix-multiplication/
 * difficulty: MEDIUM
 * topics: MATH
 * help: https://es.wikihow.com/multiplicar-matrices
 */
public class MatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] ans = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < B[0].length; k++) {
                        ans[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }

        return ans;
    }
}
