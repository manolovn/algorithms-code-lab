package dev.manolovn.verticalorder;

import dev.manolovn.common.TreeNode;
import kotlin.Pair;

import java.util.*;

/**
 * source: https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * difficulty: MEDIUM
 * topic: BFS + DFS
 */
public class VerticalOrder {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> out = new ArrayList<>();

        // map { column => values }
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        int minCol = 0;
        int maxCol = 0;

        int col = 0;
        Queue<Pair<Integer, TreeNode>> q = new ArrayDeque<>();
        q.offer(new Pair<>(col, root));
        while (!q.isEmpty()) {
            Pair<Integer, TreeNode> p = q.poll();
            col = p.getFirst();
            root = p.getSecond();
            if (root == null) continue;
            if (!columnMap.containsKey(col)) columnMap.put(col, new ArrayList<>());

            columnMap.get(col).add(root.val);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            q.offer(new Pair<>(col - 1, root.left));
            q.offer(new Pair<>(col + 1, root.right));
        }

        for (int i = minCol; i <= maxCol; i++) {
            out.add(columnMap.get(i));
        }

        return out;
    }
}
