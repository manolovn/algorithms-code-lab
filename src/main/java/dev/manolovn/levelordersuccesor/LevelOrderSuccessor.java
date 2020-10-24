package dev.manolovn.levelordersuccesor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a node, find the level order successor of the given node in the tree.
 * The level order successor is the node that appears right after the given node in the level order traversal
 *
 * Difficulty: EASY
 * Topic: BFS
 */
class LevelOrderSuccessor {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static TreeNode findSuccessor(TreeNode root, int key) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode c = q.poll();
                if (c.val == key) {
                    break;
                }
                if (c.left != null) {
                    q.offer(c.left);
                }
                if (c.right != null) {
                    q.offer(c.right);
                }
            }
        }
        return q.peek();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
