package dev.manolovn.hourglasssum;

/**
 * Source: https://www.hackerrank.com/challenges/2d-array/problem
 */
public class HourglassSum {

    /**
     * The idea to solve it is very simple, just traverse the input matrix taking care
     * of indexes, limits of the matrix and to initialize the value to the minimum possible value.
     * In this case I'll initialize it with Integer.MIN_VALUE
     */
    static int hourglassSum(int[][] arr) {
        int M = arr.length - 2;
        int N = arr[0].length - 2;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int hourglass = arr[i][j]
                        + arr[i][j + 1]
                        + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j]
                        + arr[i + 2][j + 1]
                        + arr[i + 2][j + 2];
                max = Math.max(max, hourglass);
            }
        }
        return max;
    }
}
