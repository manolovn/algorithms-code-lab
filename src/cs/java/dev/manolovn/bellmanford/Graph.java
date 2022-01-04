package dev.manolovn.bellmanford;

import java.util.ArrayList;
import java.util.List;

class Graph {

    int nodes; // nodes count
    List<Edge> edges;

    public Graph(int nodes) {
        this.nodes = nodes;
        edges = new ArrayList<>();
    }

    public void addEdge(int from, int to, int weight) {
        Edge e = new Edge(from, to, weight);
        edges.add(e);
    }
}
