package dev.manolovn.taskscheduling;

import java.util.*;

/**
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be
 * completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it
 * is possible to schedule all the tasks.
 *
 * Example:
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 * Output: true
 * Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs to finish
 * before '2' can be scheduled. A possible sceduling of tasks is: [0, 1, 2]
 *
 * difficulty: MEDIUM
 * topics: GRAPHS + TOPOLOGICAL SORT
 */
public class TaskScheduling {

    public static boolean isSchedulingPossible(int tasks, int[][] edges) {
        List<Integer> order = new ArrayList<>();
        // { 0, 1 }, { 1, 2 }, { 2, 0 }
        // 1. init the graph
        Map<Integer, Integer> incoming = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            incoming.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        // 2. init the graph
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            incoming.put(edge[1], incoming.get(edge[1]) + 1);
        }
        // 3. init dfs with sources
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : incoming.entrySet()) {
            if (entry.getValue() == 0)
                q.offer(entry.getKey());
        }
        // 4. dfs
        while (!q.isEmpty()) {
            int current = q.poll();
            order.add(current);
            for (Integer child : graph.get(current)) {
                incoming.put(child, incoming.get(child) - 1);
                if (incoming.get(child) == 0)
                    q.offer(child);
            }
        }

        return order.size() == tasks;
    }
}
