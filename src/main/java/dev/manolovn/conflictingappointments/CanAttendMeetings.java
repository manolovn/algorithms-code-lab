package dev.manolovn.conflictingappointments;

import java.util.Arrays;

/**
 * source: https://leetcode.com/problems/meeting-rooms/
 * difficulty: EASY
 * topic: INTERVALSS
 */
public class CanAttendMeetings {

    /**
     * Time:  O(nlogn)
     * Space: O(1)
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}
