package dev.manolovn.treepathsum;

/**
 * Given a binary tree where each node can only have a digit (0-9) value,
 * each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths
 * <p>
 * Difficulty: MEDIUM
 * Topics: TREE + DFS
 */
class SumOfPathNumbers {

    /**
     * Time:  O(n)
     * Space: O(n) ; due to to recursion stack
     */
    public static int findSumOfPathNumbers(TreeNode root) {
        return findPath(root, 0);
    }

    private static int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = 10 * sum + node.val;

        if (node.right == null && node.left == null) {
            return sum;
        }

        return findPath(node.left, sum) + findPath(node.right, sum);
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
