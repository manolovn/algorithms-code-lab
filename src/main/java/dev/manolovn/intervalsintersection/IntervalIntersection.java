package dev.manolovn.intervalsintersection;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode.com/problems/interval-list-intersections/
 * difficulty: MEDIUM
 * topic: INTERVALS
 */
public class IntervalIntersection {

    /**
     * time:  O(n+m)
     * space: O(n+m)
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> out = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][0] >= B[j][0] && A[i][0] <= B[j][1]
                    || A[i][0] <= B[j][0] && A[i][1] >= B[j][0]) {
                out.add(new int[]{
                        Math.max(A[i][0], B[j][0]),
                        Math.min(A[i][1], B[j][1])
                });
            }
            if (A[i][1] > B[j][1]) j++;
            else i++;
        }
        return out.toArray(new int[0][0]);
    }

    /**
     * Alternative solution
     * time:  O(n+m)
     * space: O(n+m)
     */
    public int[][] intervalIntersection_alternative(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])  i++;
            else j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
