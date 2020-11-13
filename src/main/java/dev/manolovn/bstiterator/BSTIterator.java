package dev.manolovn.bstiterator;

import dev.manolovn.common.TreeNode;

import java.util.Stack;

/**
 * source: https://leetcode.com/problems/binary-search-tree-iterator/
 * difficulty: MEDIUM
 * topic: BST
 */
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.leftmost(root);
    }

    private void leftmost(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /**
     * Time:  O(n)
     * Space: O(H) ; H is the height of the tree
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = this.stack.pop();
        if (node.right != null) {
            this.leftmost(node.right);
        }
        return node.val;
    }

    /**
     * Time: O(1)
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}

/*
  Your BSTIterator object will be instantiated and called as such:
  BSTIterator obj = new BSTIterator(root);
  int param_1 = obj.next();
  boolean param_2 = obj.hasNext();
 */
