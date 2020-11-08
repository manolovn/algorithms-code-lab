package dev.manolovn.sumroottoleaf;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * source: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * difficulty: EASY
 * topic: DFS
 */
public class SumRootToLeaf {

    /*
    iterative dfs preorder
    Time:  O(n)
    Space: O(H) ; where H is the tree height needed by the stack
    */
    public int sumNumbers(TreeNode root) {
        int result = 0;
        int current;

        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.key;
            current = p.value;

            if (root != null) {
                current = current * 10 + root.val;
                if (root.left == null && root.right == null) {
                    result += current;
                } else {
                    stack.push(new Pair<>(root.right, current));
                    stack.push(new Pair<>(root.left, current));
                }
            }
        }

        return result;
    }

    public static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class TreeNode {
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
