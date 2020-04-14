package dev.manolovn.islandcount;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IslandCount {

    /*
      [0 1 0 1 0]
      [0 0 1 1 1]
      [1 0 0 1 0]
      [0 1 1 0 0]
      [1 0 1 0 1]

      brute : O(n^2)
      bfs : O(m * n)

      for x...m.lenght
        for y...m[x].length
          if cell = 1
           bfs(x, y)
  */
    static int getNumberOfIslands(int[][] m) {
        int islandCount = 0;
        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length; y++) {
                if (m[x][y] == 1) {
                    bfs(m, x, y);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private static void bfs(int[][] m, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node c = q.remove(); // current
            m[c.x][c.y] = 0;
            q.addAll(neighbors(m, c));
        }
    }

    private static List<Node> neighbors(int[][] m, Node n) {
        List<Node> nodes = new ArrayList<>();
        if (isValid(m, n.x, n.y + 1)) {
            nodes.add(new Node(n.x, n.y + 1));
        }
        if (isValid(m, n.x + 1, n.y)) {
            nodes.add(new Node(n.x + 1, n.y));
        }
        if (isValid(m, n.x, n.y - 1)) {
            nodes.add(new Node(n.x, n.y - 1));
        }
        if (isValid(m, n.x - 1, n.y)) {
            nodes.add(new Node(n.x - 1, n.y));
        }
        return nodes;
    }

    private static boolean isValid(int[][] m, int x, int y) {
        return x >= 0 && x < m.length && y >= 0 && y < m[x].length && m[x][y] == 1;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
