package dev.manolovn.insertinterval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the correct position and merge all necessary intervals to produce a list
 * that has only mutually exclusive intervals.
 * <p>
 * Example:
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7]
 * <p>
 * Difficulty: MEDIUM
 * Topics: INTERVALS
 */
class InsertInterval {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        // add left-side intervals not coupling with newInterval
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i++));
        }

        // merge coupling intervals with newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.min(newInterval.end, intervals.get(i).end);
            i++;
        }

        // add newInterval
        mergedIntervals.add(newInterval);

        // add right-side intervals not coupling with newInterval
        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;
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
