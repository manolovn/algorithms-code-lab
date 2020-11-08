package dev.manolovn.binarytreepaths;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode.com/problems/binary-tree-paths/
 * difficulty: EASY
 * topics: STRING + DFS
 */
public class BinaryTreePaths {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths); // TODO: improve with StringBuilder
        return paths;
    }

    private void dfs(TreeNode node, String current, List<String> paths) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            paths.add(current + node.val);
            return;
        }
        dfs(node.right, current + node.val + "->", paths);
        dfs(node.left, current + node.val + "->", paths);
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
