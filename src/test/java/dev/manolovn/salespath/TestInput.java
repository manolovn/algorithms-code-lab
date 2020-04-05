package dev.manolovn.salespath;

import dev.manolovn.salespath.SalesPath.Node;

class TestInput {

    static Object[] input0() {
        Node root = new Node(0);
        Node node5 = new Node(5);
        Node node3 = new Node(3);
        Node node6 = new Node(6);
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node5_2 = new Node(5);
        Node node1_2 = new Node(1);
        Node node10 = new Node(10);
        Node node1_3 = new Node(1);

        root.children = new Node[]{node5, node3, node6};
        node5.children = new Node[]{node4};
        node3.children = new Node[]{node2, node0};
        node6.children = new Node[]{node1, node5_2};
        node2.children = new Node[]{node1_2};
        node0.children = new Node[]{node10};
        node1_2.children = new Node[]{node1_3};
        return new Object[]{root, 71};
    }
}
