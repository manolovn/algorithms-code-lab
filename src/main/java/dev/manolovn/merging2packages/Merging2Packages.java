package dev.manolovn.merging2packages;

import java.util.HashMap;
import java.util.Map;

public class Merging2Packages {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public int[] getIndicesOfItemWeights(int[] arr, int limit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return new int[]{i, map.get(arr[i])};
            }
            int diff = limit - arr[i];
            map.put(diff, i);
        }
        return new int[]{};
    }

    /**
     * If we transform this problem statement and we assume that the input is sorted,
     * a better solution would be to use a two pointers approach.
     * <p>
     * Time:  O(n)
     * Space: O(1)
     */
    public static int[] search(int[] arr, int targetSum) {
        int start = 0;
        int end = arr.length - 1;
        while (end > start) {
            int current = arr[end] + arr[start];
            if (current == targetSum) {
                return new int[]{start, end};
            }
            if (current > targetSum) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{};
    }
}
