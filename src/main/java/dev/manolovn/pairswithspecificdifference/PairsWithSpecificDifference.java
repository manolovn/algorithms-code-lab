package dev.manolovn.pairswithspecificdifference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsWithSpecificDifference {

    /**
     * map { -1: 0, -2:is,  }
     * k = 1
     * [0, -1, -2, 2, 1]
     * ^j
     * [is,j]
     * time O(n)
     * space O(n)
     *
     *
     * TODO: try to find a rec, dp,...
     */
    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        List<Pair> n = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = arr[i] - k;
            m.put(diff, i);
        }

        for (int value : arr) {
            if (m.containsKey(value)) {
                int index = m.get(value);
                n.add(new Pair(arr[index], value));
            }
        }

        int[][] solution = new int[n.size()][2];
        for (int i = 0; i < n.size(); i++) {
            solution[i] = new int[]{n.get(i).x, n.get(i).y};
        }

        return solution;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
