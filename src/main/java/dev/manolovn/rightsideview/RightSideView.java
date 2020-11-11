package dev.manolovn.rightsideview;

import dev.manolovn.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * source: https://leetcode.com/problems/binary-tree-right-side-view/
 * difficulty: MEDIUM
 * topic: BFS + DFS
 */
public class RightSideView {

    /**
     * Time:  O(n)
     * Space: O(D) ; D is the tree diameter
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> sol = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            sol.add(q.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode c = q.poll();
                if (c.right != null) q.add(c.right);
                if (c.left != null) q.add(c.left);
            }
        }

        return sol;
    }
}
