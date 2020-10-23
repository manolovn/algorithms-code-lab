package dev.manolovn.levelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal.
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays
 *
 * Difficulty: EASY
 * Topic: BST
 */
class LevelOrderTraversal {

    /**
     * Time:  O(n)
     * Space: O(1) ; ignoring the space needed to store the result
     *             ; if we not ignore the space needed to store the result is O(n)
     */
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode c = q.poll();
                list.add(c.val);
                if (c.left != null) {
                    q.offer(c.left);
                }
                if (c.right != null) {
                    q.offer(c.right);
                }
            }
            result.add(list);
        }
        return result;
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
