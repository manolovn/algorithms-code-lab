package dev.manolovn.treediameter;

import dev.manolovn.common.TreeNode;

/**
 * source: https://leetcode.com/problems/diameter-of-binary-tree/
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 * Note: You can always assume that there are at least two leaf nodes in the given tree
 * <p>
 * Difficulty: MEDIUM
 * Topic: TREE
 */
class TreeDiameter {

    static int max = 0;

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public static int findDiameter(TreeNode root) {
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
