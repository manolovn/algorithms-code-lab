package dev.manolovn.shortestcellpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestCellPath {

    /*
      [1, 1, 1, 1]
      [0, 0, 0, 1]
      [1, 1, 1, 1]
      sr = 0, sc = 0, tr = 2, tc = 0


      [(1), 1, 1, 1]
      [ 0,  0, 0, 1]
      [(1), 0, 1, 1]

      possible
      counter
      bfs()
    */
    static int shortestCellPath(int[][] grid, int sx, int sy, int ex, int ey) {
        int stepCounter = 0;
        boolean possible = false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy));

        while (!queue.isEmpty()) {
            Node c = queue.remove(); // current node
            if (c.x == ex && c.y == ey) {
                possible = true;
                break;
            }
            grid[c.x][c.y] = 0; // disable the visited node
            stepCounter++;
            queue.addAll(neighbors(grid, c));
        }

        return possible ? stepCounter : -1;
    }

    private static List<Node> neighbors(int[][] grid, Node cn) {
        List<Node> ns = new ArrayList<>();

        if (isValid(grid, cn.x - 1, cn.y)) {
            ns.add(new Node(cn.x - 1, cn.y));
        }
        if (isValid(grid, cn.x, cn.y - 1)) {
            ns.add(new Node(cn.x, cn.y - 1));
        }
        if (isValid(grid, cn.x + 1, cn.y)) {
            ns.add(new Node(cn.x + 1, cn.y));
        }
        if (isValid(grid, cn.x, cn.y + 1)) {
            ns.add(new Node(cn.x, cn.y + 1));
        }

        return ns;
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] != 0;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
