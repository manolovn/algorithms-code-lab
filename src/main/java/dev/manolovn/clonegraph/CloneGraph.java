package dev.manolovn.clonegraph;

import dev.manolovn.common.Node;

import java.util.*;

/**
 * source: https://leetcode.com/problems/clone-graph/
 * difficulty: MEDIUM
 * topic: GRAPH + DFS + BFS
 */
public class CloneGraph {

    /**
     * Time:  O(n+m); n are the nodes, m are the edges
     * Space: O(n)
     */
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    public Node dfs(Node node, Map<Integer, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);

        Node copy = new Node(node.val);
        map.put(copy.val, copy);
        for (Node n : node.neighbors)
            copy.neighbors.add(dfs(n, map));
        return copy;
    }

    /**
     * Alternative version using BFS
     * <p>
     * Time:  O(n+m) ; n are the nodes, m are the edges
     * Space: O(n)
     */
    public Node cloneGraph_alt(Node node) {
        if (node == null) return node;

        Map<Node, Node> visited = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        q.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (Node nei : current.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, new Node(nei.val, new ArrayList<>()));
                    q.add(nei);
                }
                visited.get(current).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }
}
