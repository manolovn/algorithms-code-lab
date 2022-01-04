package dev.manolovn.bellmanford;

public class BellmanFord {

    final static int INFINITY = Integer.MAX_VALUE;

    public static boolean getShortestPaths(Graph g, int source, int[] distance) {
        int nodeCount = g.nodes;
        
        // Step 1: initializing distances from source to other nodes
        for (int i = 1; i < nodeCount; i++) {
            distance[i] = INFINITY;
        }
        distance[source] = 0;

        // Step 2: relaxing edges
        for (int i = 1; i < nodeCount; i++) {
            for (Edge e : g.edges) {
                int from = e.from;
                int to = e.to;
                int weight = e.weight;
                if (distance[from] != INFINITY && distance[to] > distance[from] + weight) {
                    distance[to] = distance[from] + weight;
                }
            }
        }

        // Step 3: checks if there exist negative cycles in the graph
        for (Edge e : g.edges) {
            int u = e.from, v = e.to, w = e.weight;
            if (distance[u] != INFINITY && distance[v] > distance[u] + w) {
                return true;
            }
        }

        return false;
    }
}
