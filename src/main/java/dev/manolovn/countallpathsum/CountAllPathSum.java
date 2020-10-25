package dev.manolovn.countallpathsum;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values
 * of each path equals ‘S’. Please note that the paths can start or end at any node but all paths must follow
 * direction from parent to child (top to bottom)
 *
 * Difficulty: MEDIUM
 * Topics: TREE
 */
public class CountAllPathSum {

    /**
     * Time:  O(n^2)
     * Space: O(n)
     */
    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    private static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {
        if (currentNode == null)
            return 0;

        currentPath.add(currentNode.val);
        int pathCount = 0, pathSum = 0;
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == S) {
                pathCount++;
            }
        }

        pathCount += countPathsRecursive(currentNode.left, S, currentPath);
        pathCount += countPathsRecursive(currentNode.right, S, currentPath);
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
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
