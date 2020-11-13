package dev.manolovn.verticalordertraversal;

import dev.manolovn.common.TreeNode;

import java.util.*;

/**
 * source: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * difficulty: MEDIUM
 * topic: BFS + DFS
 */
public class VerticalOrderTraversalBinaryTree {

    /**
     * Time:  O(nlogn)
     * Space: O(n)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // map: key=column; value=Pair(row, value)
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        int mincol = 0;
        int maxcol = 0;

        // bfs
        int row = 0;
        int col = 0;
        Queue<Pair<TreeNode, int[]>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, new int[]{row, col}));
        while (!q.isEmpty()) {
            Pair<TreeNode, int[]> c = q.remove();
            root = c.key;
            row = c.value[0];
            col = c.value[1];
            if (root != null) {
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(new Pair<>(row, root.val));

                mincol = Math.min(mincol, col);
                maxcol = Math.max(maxcol, col);

                q.offer(new Pair<>(root.left, new int[]{row + 1, col - 1}));
                q.offer(new Pair<>(root.right, new int[]{row + 1, col + 1}));
            }
        }

        // retrieve values from map
        for (int i = mincol; i < maxcol + 1; i++) {
            map.get(i).sort((a, b) -> {
                if (a.key.equals(b.key)) {
                    return a.value - b.value; // order by value in the same column
                } else {
                    return a.key - b.key; // order by row
                }
            });

            // move the values from the map to the result collection
            List<Integer> sorted = new ArrayList<>();
            for (Pair<Integer, Integer> p : map.get(i)) {
                sorted.add(p.value);
            }
            result.add(sorted);
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
}
