package dev.manolovn.flyaway;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Fly away
 * --------
 * You are given a list of flight start and end times.
 * Determine the maximum amount of airplanes in the air
 * at the same time.
 * <p>
 * Example:
 * flights: [[2,5],[3,7],[8,9],[9,11]]
 * answer: 2
 */
public class FlyAway {

    /**
     * Time:  O(nlogn)
     * Space: O(n)
     */
    public static int flyAway(int[][] flights) {
        Flight[] fs = new Flight[flights.length];
        for (int i = 0; i < flights.length; i++) {
            fs[i] = new Flight(flights[i][0], flights[i][1]);
        }
        return flyAway(fs);
    }

    private static int flyAway(Flight[] flights) {
        Arrays.sort(flights, (a, b) -> a.start - b.start);
        int max = 0;
        PriorityQueue<Flight> heap = new PriorityQueue<>(flights.length, (a, b) -> a.end - b.end);
        for (Flight f : flights) {
            while (!heap.isEmpty() && f.start >= heap.peek().end) {
                heap.poll();
            }
            heap.offer(f);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    static class Flight {
        int start;
        int end;

        public Flight(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        System.out.println("Fly awaaaaay!");
        int[][] test1 = new int[][]{{2, 5}, {3, 7}, {8, 9}, {9, 11}};
        System.out.println("TEST #1 : " + flyAway(test1));
    }
}
