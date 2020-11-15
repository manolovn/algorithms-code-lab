package dev.manolovn.binarytreetodll;

/**
 * source: https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * difficulty: MEDIUM
 * topic: BST
 */
public class ConvertBSTToSortedDoublyLinkedList {

    Node first;
    Node last;

    /**
     * Time:  O(n)
     * Space: O(logn) for balanced tree; O(n) for completely unbalanced tree
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void helper(Node node) {
        if (node == null) return;
        helper(node.left);
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }
        last = node;
        helper(node.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
