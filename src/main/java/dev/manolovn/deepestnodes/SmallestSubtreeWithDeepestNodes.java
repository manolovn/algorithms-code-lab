package dev.manolovn.deepestnodes;

/**
 * source: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 * difficulty: MEDIUM
 * topics: TREE + GRAPH + BINARY TREE
 */
public class SmallestSubtreeWithDeepestNodes {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == rightHeight) {
            return root;
        }
        if (leftHeight > rightHeight) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
