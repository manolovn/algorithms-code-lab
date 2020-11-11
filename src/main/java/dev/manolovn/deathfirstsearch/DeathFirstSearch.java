package dev.manolovn.deathfirstsearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Death first search
 * ==================
 * The world is being infected by zombies!!!
 * Given a matrix, every `1` represents a zombie and every `0` is a human.
 * Every day, a zombie infects all the humans in the eight directions.
 * How many days could resists the world until all the humans become zombies?
 * <p>
 * [0 0 0 1 1 0]
 * [0 0 0 0 0 0]
 * [1 0 0 0 0 0]
 * <p>
 * difficulty: MEDIUM
 * topics: BFS
 */
public class DeathFirstSearch {

    /*
    #1: bfs
     1. find the zombies
     2. infecting counting the days
     3. yummy!
    */

    /*
    Time:  O(n*m)
    Space: O(n*m)
    */
    static int solution(int[][] input) {
        int days = -1;
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 1) { // ZOMBIE!
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0},
                {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] next = q.poll();
                for (int[] dir : dirs) {
                    int x = next[0] + dir[0];
                    int y = next[1] + dir[1];
                    if (isCellValid(x, y, input)) {
                        input[x][y] = 1;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            days++;
        }

        return Math.max(days, 0);
    }

    private static boolean isCellValid(int x, int y, int[][] input) {
        return x >= 0 && x < input.length
                && y >= 0 && y < input[0].length
                && input[x][y] == 0;
    }

    public static void main(String[] args) {
        System.out.println("Dead Inside, dont code!");
        int[][] world = new int[][]{
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0}
        };
        System.out.println("The world is infected after " + solution(world) + " days");
        int[][] world2 = new int[][]{
                {1, 1},
                {1, 1}
        };
        System.out.println("The world is infected after " + solution(world2) + " days");
        int[][] world3 = new int[][]{};
        System.out.println("The world is infected after " + solution(world3) + " days");
        int[][] world4 = new int[][]{
                {0, 0}
        };
        System.out.println("The world is infected after " + solution(world4) + " days");
        int[][] world5 = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("The world is infected after " + solution(world5) + " days");
    }
}
