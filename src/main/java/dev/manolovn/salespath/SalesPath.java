package dev.manolovn.salespath;

import java.util.Arrays;

public class SalesPath {

    static class Node {
        int cost;
        Node[] children = new Node[]{};

        Node(int cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return String.format("(%d) -> %s", cost, Arrays.toString(children));
        }
    }

    int getCheapestCost(Node rootNode) {
        if (rootNode.children.length == 0) {
            return rootNode.cost;
        }
        int minCost = Integer.MAX_VALUE;
        for (int c = 0; c < rootNode.children.length; c++) {
            minCost = Math.min(minCost, getCheapestCost(rootNode.children[c]));
        }
        return minCost + rootNode.cost;
    }
}
