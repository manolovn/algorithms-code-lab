package dev.manolovn.treepathsum;

/**
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf
 * such that the sum of all the node values of that path equals ‘S’
 */
class TreePathSum {

    /**
     * Time:  O(n)
     * Space: O(n) ; due to the recursion call stack
     */
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.val == sum && root.right == null && root.left == null)
            return true;

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
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
