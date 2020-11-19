package dev.manolovn.searchmatrix;

/**
 * source: https://leetcode.com/problems/search-a-2d-matrix/
 * difficulty: MEDIUM
 * topic: BINARY SEARCH
 */
public class SearchMatrix {

    /*
    [  1  3  5  7 ]
    [ 10 11 16 20 ]
    [ 23 30 34 50 ]
    target = 3

    - Approaches -
    #0: brute force
    t: O(n*m)
    s: O(1)
    ---
    >#1: binary search
    [  1  3  5  7 ] [ 10 11 16 20 ] [ 23 30 34 50 ]
    t: O(log(m*n))
    s: O(1)

    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int num = matrix[mid / n][mid % n];
            if (num == target) {
                return true;
            } else if (num > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
