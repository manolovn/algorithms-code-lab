package dev.manolovn.longestarithmeticlen;

import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/longest-arithmetic-sequence/
 * difficulty: MEDIUM
 * topic: DP
 */
public class LongestArithmeticSequenceLength {

    /*
    [9,4,7,2,10]

    #1: dp



    t: O(n^2)
    s: O(n)
    */
    public int longestArithSeqLength(int[] A) {
        // initialize the maps
        Map<Integer, Integer>[] map = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) map[i] = new HashMap<>();

        int max = 0;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int count = map[j].getOrDefault(diff, 1);
                max = Math.max(max, count + 1);
                map[i].put(diff, count + 1);
            }
        }

        return max;
    }
}
