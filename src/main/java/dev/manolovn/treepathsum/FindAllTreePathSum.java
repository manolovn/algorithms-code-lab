package dev.manolovn.treepathsum;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf
 * such that the sum of all the node values of each path equals ‘S’
 *
 * Difficulty: MEDIUM
 * Topics: TREE + DFS
 */
class FindAllTreePathSum {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathRec(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathRec(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }
        currentPath.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findPathRec(node.left, sum - node.val, currentPath, allPaths);
            findPathRec(node.right, sum - node.val, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
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
