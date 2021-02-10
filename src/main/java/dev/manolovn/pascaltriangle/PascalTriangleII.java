package dev.manolovn.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode.com/problems/pascals-triangle-ii
 * difficulty: EASY
 * topic: ARRAYS + MATH
 */
public class PascalTriangleII {

    /*
    0 - 1 0 0 0 0
    1 - 1 1 0 0 0
    2 - 1 2 1 0 0
    3 - 1 3 3 1 0
    4 - 1 4 6 4 1

    Following the iterations of the Pascal triangle is easy to think that
    every row contains rowIndex + 1 elements.

    Time: O(k^2)
    Space: O(k)
    */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>(rowIndex + 1) {{
            add(1);
        }};

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }

        return row;
    }

    /**
     * Math based alternative
     * In mathematics, Pascal's triangle is a triangular array of the binomial coefficients.
     * So the entry nth row and rth column of Pascal triangle is as the binomial (n r)
     * check the Pascal rule: https://en.wikipedia.org/wiki/Pascal%27s_rule
     *
     * Time: O(k)
     * Space: O(k)
     */
    public List<Integer> getRow_mathAlternative(int n) {
        List<Integer> row = new ArrayList<Integer>() {{
            add(1);
        }};

        for (int k = 1; k <= n; k++) {
            row.add((int) ((row.get(row.size() - 1) * (long) (n - k + 1)) / k));
        }

        return row;
    }
}
