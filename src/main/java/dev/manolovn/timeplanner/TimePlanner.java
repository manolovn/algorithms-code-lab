package dev.manolovn.timeplanner;

/**
 * Time planner
 * ------------
 * Implement a function `meetingPlanner` that given the availability, slotsA and slotsB, of two people
 * and a meeting duration dur, returns the earliest time slot that works for both of them and is of duration dur.
 * If there is no common time slot that satisfies the duration requirement, return an empty array.
 */
public class TimePlanner {

    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int j = 0;

        for (int[] ints : slotsA) {
            int startA = ints[0];
            int endA = ints[1];
            int startB = slotsB[j][0];
            int endB = slotsB[j][1];

            if (startA + dur <= endB && startB + dur <= endA) {
                return new int[]{Math.max(startA, startB), Math.min(startA, startB) + dur};
            }

            if (startA + dur > endB || startB + dur > endA) {
                j++;
            }
        }

        return new int[]{};
    }
}
