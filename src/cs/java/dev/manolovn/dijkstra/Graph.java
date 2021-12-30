package dev.manolovn.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append("->").append(node);
        }
        return sb.toString();
    }
}
