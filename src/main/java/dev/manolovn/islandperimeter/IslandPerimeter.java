package dev.manolovn.islandperimeter;

/**
 * source: https://leetcode.com/problems/island-perimeter/
 * difficulty: EASY
 * topic: ARRAYS
 */
public class IslandPerimeter {

    /*
    The approach is to traverse the island and count the perimeter following the next rule:
    - perimeter count on every cell is equal to the 4 - (number of visitable neighbors);
    so when I have 4 visitable neighbors, perimeter count is 0 and when I have only one
    visitable neighbor is 3,... and so on
    - it's important to take into account that it's necessary to modify the grid to mark
    visited nodes. In this case, a visited node will have the value of 2

    Complexity:
    Time:  O(N) ; where N is the size of the grid
    Space: O(1) ; no need extra data structures
    */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    perimeter += 4 - visitableNodes(grid, r, c);
                }
            }
        }
        return perimeter;
    }

    private int visitableNodes(int[][] g, int r, int c) {
        int count = 0;
        if (r - 1 >= 0 && g[r - 1][c] == 1) count++;
        if (r + 1 < g.length && g[r + 1][c] == 1) count++;
        if (c - 1 >= 0 && g[r][c - 1] == 1) count++;
        if (c + 1 < g[r].length && g[r][c + 1] == 1) count++;
        return count;
    }
}
