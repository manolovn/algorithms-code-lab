package dev.manolovn.pathgivensequence;

/**
 * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree
 *
 * Difficulty: MEDIUM
 * Topics: TREE + DFS
 */
class PathGivenSequence {

    /**
     * Time:  O(n)
     * Space: O(n) ; due to the recursive stack
     */
    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPathRec(root, sequence, 0);
    }

    private static boolean findPathRec(TreeNode node, int[] seq, int level) {
        if (node == null) {
            return false;
        }
        if (level >= seq.length || seq[level] != node.val) {
            return false;
        }

        if (node.left == null && node.right == null && level == seq.length - 1) {
            return true; // we found a path
        }

        return findPathRec(node.left, seq, level + 1)
                || findPathRec(node.right, seq, level + 1);
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
