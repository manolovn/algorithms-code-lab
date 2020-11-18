package dev.manolovn.graphbipartite;

import java.util.Arrays;
import java.util.Stack;

/**
 * source: https://leetcode.com/problems/is-graph-bipartite/
 * difficulty: MEDIUM
 * topic: GRAPH + DFS + BFS
 */
public class IsGraphBipartite {

    /**
     * Time:  O(N+E) ; N are the number of nodes and E the edges
     * Space: O(N) ; to store the colors
     */
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                // iterative dfs
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    for (int nei : graph[current]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[current] ^ 1;
                        } else if (color[nei] == color[current]) {
                            return false;
                        }
                    } // O(E)
                }
            }
        } // O(N + E)

        return true;
    }
}
