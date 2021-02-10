package dev.manolovn.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode.com/problems/pascals-triangle/
 * difficulty: EASY
 * topic: ARRAYS
 */
public class PascalTriangle {

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        List<List<Integer>> rows = new ArrayList<List<Integer>>(numRows + 1) {{
            add(new ArrayList<Integer>(numRows + 1){{
                add(1);
            }});
        }};

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>(numRows + 1) {{
                add(1);
            }};
            List<Integer> prevRow = rows.get(i-1);
            for (int j = 1; j < i; j++) {
                row.add(j, prevRow.get(j) + prevRow.get(j - 1));
            }
            row.add(1);
            rows.add(row);
        }

        return rows;
    }
}
