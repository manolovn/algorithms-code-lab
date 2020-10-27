package dev.manolovn.kclosestpoints;

import java.util.PriorityQueue;

/**
 * source: https://leetcode.com/problems/k-closest-points-to-origin
 * difficulty: MEDIUM
 * topics: HEAP
 */
public class KClosestPoints {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> distances = new PriorityQueue<>(K);
        for (int[] point : points) {
            distances.offer(dist(point));
        } // O(nlogk)
        int limit = 0;
        for (int i = 0; i < K; i++) {
            limit = distances.poll();
        } // O(klogk)
        int[][] r = new int[K][2];
        int idx = 0;
        for (int[] point : points) {
            if (dist(point) <= limit) {
                r[idx] = point;
                idx++;
            }
        } // O(n)
        return r;
        // Time:  O(nlogk)
        // Space: O(k)
    }

    private int dist(int[] point) {
        int x = point[0];
        int y = point[1];
        return x*x + y*y;
    }
}
