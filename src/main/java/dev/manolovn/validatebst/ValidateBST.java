package dev.manolovn.validatebst;

import dev.manolovn.common.TreeNode;

/**
 * source: https://leetcode.com/problems/validate-binary-search-tree/
 * difficulty: EASY
 * topic: BST
 */
public class ValidateBST {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public boolean isValidBST(TreeNode root) {
        return rec(root, null, null);
    }

    private boolean rec(TreeNode n, Integer min, Integer max) {
        if (n == null) return true;
        if (min != null && n.val <= min) return false;
        if (max != null && n.val >= max) return false;
        return rec(n.left, min, n.val) && rec(n.right, n.val, max);
    }
}
