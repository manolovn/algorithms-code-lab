package dev.manolovn.leftmostcolumn;

import java.util.List;

/**
 * source: https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 * difficulty: MEDIUM
 * topic: ARRAYS
 */
public class LeftmostColumn {

    /**
     * time:  O(n+m) ; rows + cols
     * space: O(1)
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimens = binaryMatrix.dimensions();
        int rows = dimens.get(0);
        int cols = dimens.get(1) - 1;
        int sol = -1;
        int k = 0;
        for (int i = cols; i >= 0; i--) {
            for (int j = k; j < rows; j++, k++) {
                if (binaryMatrix.get(j, i) == 1) {
                    sol = i;
                    break;
                }
            }
        }
        return sol;
    }

    interface BinaryMatrix {
        int get(int row, int col);
        List<Integer> dimensions();
    }
}
