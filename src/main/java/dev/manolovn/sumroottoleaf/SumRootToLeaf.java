package dev.manolovn.sumroottoleaf;

import dev.manolovn.common.TreeNode;
import kotlin.Pair;

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
            root = p.getFirst();
            current = p.getSecond();

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
}
