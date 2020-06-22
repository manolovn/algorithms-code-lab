package dev.manolovn.climbingleaderboard;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * source: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */
public class ClimbingLeaderboard {

    /*
    scores: 100 100 50 40 40 20 10
    1. build the scoreboard in an array [100, 50, 40, 20, 10]
    2. traverse alice a getting index in scores

    Given n is the scores array size and m alice array size
    Time:  O(m*log(n)) ; we made "alice" times binary searches over scores array
    Space: O(m) ; moves array solution is the extra structure created with the same alice array length
    */
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        // build scoreboard (manually, creating a SortedSet<Integer> or using stream api)
        scores = IntStream.of(scores).distinct().sorted().toArray();
        // traverse scoreboard calculating climbing movements
        int[] moves = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            /*
            Arrays.binarySearch returns: index of the search key, if it is contained in the array;
            otherwise, (-(insertion point) - 1).
            The insertion point is defined as the point at which the key would be inserted into the array:
            the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key
            */
            int c = Arrays.binarySearch(scores, alice[i]);
            if (c < 0) {
                moves[i] = scores.length - Math.abs(c) + 2;
            } else {
                moves[i] = scores.length - c;
            }
        }
        return moves;
    }
}
