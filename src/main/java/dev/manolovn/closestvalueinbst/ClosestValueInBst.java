package dev.manolovn.closestvalueinbst;

import dev.manolovn.common.TreeNode;

/**
 * source: https://leetcode.com/problems/closest-binary-search-tree-value/
 * difficulty: EASY
 * topic: BST
 */
public class ClosestValueInBst {

    /**
     * Time:  O(H) ; where H is the tree height because we go only once from root to leaf
     * Space: O(1)
     */
    public int closestValue(TreeNode root, double target) {
        int solution = root.val;
        while (root != null) {
            int val = root.val;
            solution = Math.abs(val - target) < Math.abs(solution - target) ? val : solution;
            root = target > val ? root.right : root.left;
        }
        return solution;
    }
}
