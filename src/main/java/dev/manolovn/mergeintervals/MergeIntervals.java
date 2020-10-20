package dev.manolovn.mergeintervals;

import java.util.*;

class MergeIntervals {

    /**
     * Time:  O(nlogn) + O(n) = O(nlogn) ; due to the sort
     * Space: O(n) ; due to the space needed to sorting
     */
    public static List<Interval> merge(List<Interval> intervals) {
        // precondition
        if (intervals.size() < 2) {
            return intervals;
        }
        // 1. sort by interval start
        intervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        // 2. create iterator and set initial state
        Iterator<Interval> iterator = intervals.iterator();
        Interval i = iterator.next();
        int start = i.start;
        int end = i.end;

        while(iterator.hasNext()) {
            i = iterator.next();
            if (i.start <= end) {
                // intervals overlaps, so increase the end of the interval
                end = Math.max(end, i.end);
            } else {
                // add the current interval as merged
                mergedIntervals.add(new Interval(start, end));
                // reset state to the next interval
                start = i.start;
                end = i.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

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
