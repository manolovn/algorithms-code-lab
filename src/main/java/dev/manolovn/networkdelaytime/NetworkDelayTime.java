package dev.manolovn.networkdelaytime;

import java.util.*;

/**
 * source: https://leetcode.com/problems/network-delay-time/
 * difficulty: MEDIUM
 */
public class NetworkDelayTime {

    /*
    Approach:
    1. build the graph from times matrix
    2. calculate the maximum path in that graph from the node k
       - basic dijkstra: O(n^2)
       - TODO: heap implementation: O(nlogn)
       - TODO: another solution based on DFS?
    3. extract max from distances array
    Complexity:
    Time:  O(n^2 + E) ; where E is the size of times matrix
    Space: O(n + E) ; where O(n) is from the distances array
                        and O(E) is the size needed by the graph
    */
    public int networkDelayTime(int[][] times, int N, int K) {
        // construct the graph
        Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
        for (int[] e: times) {
            costs.putIfAbsent(e[0], new HashMap<>());
            costs.get(e[0]).put(e[1], e[2]);
        }

        // init distances array
        int[] distances = new int[N+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[K] = 0;

        // basic dijkstra
        Queue<Integer> que = new LinkedList<>();
        boolean[] inQue = new boolean[N+1];
        que.offer(K);
        while (!que.isEmpty()) {
            int node = que.poll();
            inQue[node] = false;
            if (!costs.containsKey(node)) continue;
            for (int next: costs.get(node).keySet()) {
                int d = costs.get(node).get(next);
                if (distances[next] > distances[node] + d) {
                    distances[next] = distances[node] + d;
                    if (!inQue[next]) {
                        que.offer(next);
                        inQue[next] = true;
                    }
                }
            }
        }

        // extract max value from distances
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, distances[i]);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
