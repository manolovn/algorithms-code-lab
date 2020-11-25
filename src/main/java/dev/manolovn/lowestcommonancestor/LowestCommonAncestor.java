package dev.manolovn.lowestcommonancestor;

import dev.manolovn.common.TreeNode;

/**
 * source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * difficulty: MEDIUM
 * topic: TREE
 */
public class LowestCommonAncestor {

    TreeNode ans = null;

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        rec(root, p, q);
        return ans;
    }

    private boolean rec(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) return false;

        int left = rec(current.left, p, q) ? 1 : 0;
        int right = rec(current.right, p, q) ? 1: 0;

        int mid = (current == p || current == q) ? 1 : 0;

        if (mid + left + right >= 2) this.ans = current;

        return (mid + left + right > 0);
    }
}
