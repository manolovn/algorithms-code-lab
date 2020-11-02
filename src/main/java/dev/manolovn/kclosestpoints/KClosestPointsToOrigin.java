package dev.manolovn.kclosestpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of points in the a 2D2D2D plane, find ‘K’ closest points to the origin.
 *
 * Example:
 * Input: points = [[1,2],[1,3]], K = 1
 * Output: [[1,2]]
 * Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
 * The Euclidean distance between (1, 3) and the origin is sqrt(10).
 * Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
 *
 * difficulty: EASY
 * topics: HEAP
 */
public class KClosestPointsToOrigin {

    /**
     * Time:  O(nlogk)
     * Space: O(k)
     */
    public static List<Point> findClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<>(k, (a, b) -> b.distFromOrigin() - a.distFromOrigin());
        for (int i = 0; i < k; i++) {
            heap.offer(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < heap.peek().distFromOrigin()) {
                heap.poll();
                heap.offer(points[i]);
            }
        }
        return new ArrayList<>(heap);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            // ignoring sqrt
            return (x * x) + (y * y);
        }
    }
}
