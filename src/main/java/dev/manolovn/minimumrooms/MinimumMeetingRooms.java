package dev.manolovn.minimumrooms;

import java.util.List;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings,
 * find the minimum number of rooms required to hold all the meetings.
 *
 * Example:
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 *
 * source: https://leetcode.com/problems/meeting-rooms-ii/
 * difficulty: MEDIUM
 * topics: HEAPS + INTERVALS
 */
class MinimumMeetingRooms {

    /**
     * Time:  O(nlogn) + O(nlogn) = O(nlogn)
     * The first O(nlogn) is due to the sort, the second one is that offer in a PriorityQueue is O(logn)
     * and due this call is inside a loop -> O(nlogn)
     * Space: O(n) + O(n) = O(n)
     * The first is the space needed by the sorting
     * The second is related to the size needed by the PriorityQueue
     */
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        meetings.sort(comparingInt(a -> a.start)); // t=O(nlogn);s=O(n)
        int rooms = 0;
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), comparingInt(a -> a.end));
        for (Meeting m : meetings) {
            while (!minHeap.isEmpty() && m.start >= minHeap.peek().end) { // O(1)
                minHeap.poll(); // O(logn)
            }
            minHeap.offer(m); // O(logn)
            rooms = Math.max(rooms, minHeap.size());
        }
        return rooms;
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
