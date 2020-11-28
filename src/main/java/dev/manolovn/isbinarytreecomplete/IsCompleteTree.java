package dev.manolovn.isbinarytreecomplete;

import dev.manolovn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * source: https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * difficulty: MEDIUM
 * topic: BFS + TREE
 */
public class IsCompleteTree {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.peek() != null) {
            TreeNode node = q.poll();
            q.offer(node.left);
            q.offer(node.right);
        }

        while (q.size() > 0 && q.peek() == null)
            q.poll();

        return q.isEmpty();
    }
}
