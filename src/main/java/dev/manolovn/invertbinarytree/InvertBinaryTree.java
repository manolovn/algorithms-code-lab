package dev.manolovn.invertbinarytree;

import dev.manolovn.common.TreeNode;

/**
 * source: https://leetcode.com/problems/invert-binary-tree/submissions/
 * difficulty: EASY
 * topic: BINARY TREE
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
