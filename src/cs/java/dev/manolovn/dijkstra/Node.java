package dev.manolovn.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    String name;
    Integer distance = Integer.MAX_VALUE;

    List<Node> shortestPath = new LinkedList<>();
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(" + name + ")";
    }
}
