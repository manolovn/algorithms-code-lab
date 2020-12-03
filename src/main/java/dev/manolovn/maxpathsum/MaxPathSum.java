package dev.manolovn.maxpathsum;

import dev.manolovn.common.TreeNode;

/**
 * source: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * difficulty: HARD
 * topic: DFS + TREE
 */
public class MaxPathSum {

    int max = Integer.MIN_VALUE;

    /*
    t: O(n)
    s: O(h) ; where h is the height of the tree
    */
    public int maxPathSum(TreeNode root) {
        maxBranch(root);
        return max;
    }

    private int maxBranch(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(maxBranch(node.left), 0);
        int right = Math.max(maxBranch(node.right), 0);

        int path = node.val + left + right;
        max = Math.max(max, path);

        return node.val + Math.max(left, right);
    }
}
