package dev.manolovn.topologicalsort;

import java.util.*;

/**
 * Given a directed graph, find the topological ordering of its vertices.
 *
 * Example:
 * Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
 * Output: Following are the two valid topological sorts for the given graph:
 * 1) 3, 2, 0, 1
 * 2) 3, 2, 1, 0
 *
 * difficulty: MEDIUM
 * topic: GRAPHS + TOPOLOGICAL SORT
 */
public class TopologicalSort {

    /**
     * Time:  O(V+E)
     * Space: O(V)
     */
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // 1. init the graph
        Map<Integer, Integer> incoming = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            incoming.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        // 2. build the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            incoming.put(edge[1], incoming.get(edge[1]) + 1);
        }
        // 3. init bfs with sources
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : incoming.entrySet()) {
            if (entry.getValue() == 0)
                q.offer(entry.getKey());
        }
        // 4. bfs from sources
        while (!q.isEmpty()) {
            int current = q.poll();
            sortedOrder.add(current);
            for (Integer child : graph.get(current)) {
                incoming.put(child, incoming.get(child) - 1);
                if (incoming.get(child) == 0)
                    q.offer(child);
            }
        }

        // check cycles
        if (sortedOrder.size() != vertices) {
            return new ArrayList<>(); // because cycle :shrug:
        }
        return sortedOrder;
    }
}
