package dev.manolovn.connectlevelsiblings;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, connect each node with its level order successor.
 * The last node of each level should point to a null node
 */
class ConnectLevelOrderSiblings {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public static void connect(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode prev = null;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode c = q.poll();
                if (prev != null) {
                    prev.next = c;
                }
                prev = c;
                if (c.left != null) {
                    q.offer(c.left);
                }
                if (c.right != null) {
                    q.offer(c.right);
                }
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
            left = right = next = null;
        }
    }
}
