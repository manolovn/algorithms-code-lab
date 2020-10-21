package dev.manolovn.intervalsintersection;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of intervals, find the intersection of these two lists.
 * Each list consists of disjoint intervals sorted on their start time.
 *
 * Example:
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists
 *
 * Difficulty: MEDIUM
 * Topics: INTERVALS
 */
class IntervalsIntersection {

    /**
     * Time:  O(n+m) ; where n and m are the number of intervals of input arrays respectively
     * Space: O(n) or O(1) if we ignore the needed list to store the intersections
     */
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end ||
                    arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end) {
                intervalsIntersection.add(new Interval(
                        Math.max(arr1[i].start, arr2[j].start),
                        Math.min(arr1[i].end, arr2[j].end)
                ));
            }
            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return intervalsIntersection.toArray(new Interval[0]);
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
