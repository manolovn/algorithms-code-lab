package dev.manolovn.floodfill;

/**
 * source: https://leetcode.com/problems/flood-fill/
 * difficulty: EASY
 */
public class FloodFill {

    /**
     The approach is to implement a DFS, traversing from the starting point (sr, sc)
     checking the valid neighbors and modifying the image matrix with newColor.
     So the idea is to use a simple DFS; from the different possible implementations
     I'll use the pre-order recursive one.

     Time:  O(N) ; where N is the number of pixels in the image matrix
     Space: O(N) ; the maximum space needed by the recursive stack calls
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int prevColor = image[sr][sc];
        if (prevColor != newColor) {
            dfs(image, sr, sc, prevColor, newColor);
        }
        return image;
    }

    /**
     DFS preorder recursive implementation
     */
    private void dfs(int[][] image, int x, int y, int prevColor, int newColor) {
        if (image[x][y] != prevColor) {
            return;
        }
        image[x][y] = newColor; // visit current node

        // visit west
        if (x-1 >= 0) {
            dfs(image, x-1, y, prevColor, newColor);
        }
        // visit east
        if (x+1 < image.length) {
            dfs(image, x+1, y, prevColor, newColor);
        }
        // visit north
        if (y-1 >= 0) {
            dfs(image, x, y-1, prevColor, newColor);
        }
        // visit south
        if (y+1 < image[0].length) {
            dfs(image, x, y+1, prevColor, newColor);
        }
    }
}
