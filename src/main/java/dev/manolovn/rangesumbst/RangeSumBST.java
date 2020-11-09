package dev.manolovn.rangesumbst;

import dev.manolovn.common.TreeNode;

/**
 * source: https://leetcode.com/problems/range-sum-of-bst/
 * difficulty: EASY
 * topic: BST + DFS
 */
public class RangeSumBST {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }

    private int helper(TreeNode node, int l, int r) {
        if (node == null) return 0;
        int sum = 0;

        if (node.val >= l && node.val <= r) {
            sum += node.val;
        }
        if (node.val > l) sum += helper(node.left, l, r);
        if (node.val < r) sum += helper(node.right, l, r);

        return sum;
    }
}
