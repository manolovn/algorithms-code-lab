package dev.manolovn.carpooling;

import java.util.Map;
import java.util.TreeMap;

/**
 * source: https://leetcode.com/problems/car-pooling
 * difficulty: MEDIUM
 * topic: HEAP
 */
public class CarPooling {

    /**
     * The intuitive approach is keep the count of the capacity
     * traversing the sorted trips. To do this we could use an approach
     * based on sort the trips array + use a heap or to use a TreeMap;
     * twice approaches gives you the same complexity result.
     *
     * Time:  O(nlogn)
     * Space: O(n)
     */
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> ts = new TreeMap<>();
        for (int[] trip : trips) {
            int start = ts.getOrDefault(trip[1], 0) + trip[0]; // O(logn)
            ts.put(trip[1], start); // O(logn)
            int end = ts.getOrDefault(trip[2], 0) - trip[0]; // O(logn)
            ts.put(trip[2], end); // O(logn)
        } // O(nlogn)
        int current = 0;
        for (int change : ts.values()) {
            current += change;
            if (current > capacity) return false;
        } // O(nlogn)
        return true;
    } // O(nlogn) + O(nlogn) = O(nlogn)
}
