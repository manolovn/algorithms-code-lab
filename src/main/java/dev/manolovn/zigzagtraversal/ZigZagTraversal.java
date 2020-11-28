package dev.manolovn.zigzagtraversal;

import dev.manolovn.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * source: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p>
 * Given a binary tree, populate an array to represent its zigzag level order traversal.
 * You should populate the values of all nodes of the first level from left to right,
 * then right to left for the next level and keep alternating in the same manner for the following levels.
 * <p>
 * Difficulty: MEDIUM
 * Topic: LINKED LIST + BFS
 */
class ZigZagTraversal {

    /**
     * Time:  O(n)
     * Space: O(1) ; ignoring the needed structure to store de result output
     */
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean ltr = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode c = q.poll();
                if (ltr) list.add(c.val);
                else list.add(0, c.val);

                if (c.left != null) q.offer(c.left);
                if (c.right != null) q.offer(c.right);
            }
            ltr = !ltr;
            result.add(list);
        }
        return result;
    }
}
