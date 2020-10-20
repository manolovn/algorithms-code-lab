package dev.manolovn.conflictingappointments;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 *
 * Example:
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 *
 * Difficulty: MEDIUM
 */
class ConflictingAppointments {

    /**
     * Time:  O(nlogn) + O(n) = O(nlogn)
     * Space: O(n) ; due to space needed to sort
     */
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
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
