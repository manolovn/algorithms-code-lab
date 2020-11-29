package dev.manolovn.minbinarytreeheight;

import dev.manolovn.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * source: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * Find the minimum depth of a binary tree. The minimum depth is the number of nodes
 * along the shortest path from the root node to the nearest leaf node
 * <p>
 * Difficulty: EASY
 * Topics: BFS
 */
class MinimumBinaryTreeHeight {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static int findDepth(TreeNode root) {
        int minHeight = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            minHeight++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode c = q.poll();
                if (c.right == null && c.left == null) {
                    return minHeight;
                }
                if (c.left != null) {
                    q.offer(c.left);
                }
                if (c.right != null) {
                    q.offer(c.right);
                }
            }
        }
        return minHeight;
    }
}
