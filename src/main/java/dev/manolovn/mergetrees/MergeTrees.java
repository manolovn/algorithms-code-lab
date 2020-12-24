package dev.manolovn.mergetrees;

import dev.manolovn.common.TreeNode;

/**
 * source: https://leetcode.com/problems/merge-two-binary-trees/
 * difficulty: EASY
 * topic: BINARY TREE
 */
public class MergeTrees {

    /**
     * Time:  O(n)
     * Space: O(n) in the worst case
     *        O(logn) if the trees are balanced
     * n represents the max number of nodes in t1 and t2
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
