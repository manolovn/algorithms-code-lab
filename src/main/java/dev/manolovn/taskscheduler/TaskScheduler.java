package dev.manolovn.taskscheduler;

import java.util.Arrays;

/**
 * source: https://leetcode.com/problems/task-scheduler/
 * difficulty: MEDIUM
 * topic: GREEDY + MATH
 */
public class TaskScheduler {

    /*
    ["A","A","A","B","B","B"] ; n = 2
    freqMap : { A : 3, B : 3 }

    [ [A] [B] [idle] [A] [B] [idle] [A] [B] ]
    [ [A] [idle] [idle] [A] [idle] [idle] [A] ] <-- max idle slots = (most_frequent_task - 1) * n

    The approach is to calculate the max possible idle slots based on
    the most frequent task and use the other tasks to "fill" the idle slots
    candidates. So starting from a max number of idles slots we only need
    to discard the slots that is occupied by other tasks.

    Time:  O(n) ; where n is the number of tasks
    Space: O(1)
    */
    public int leastInterval(char[] tasks, int n) {
        // map task frequency
        int[] freqs = new int[26];
        for (int t : tasks) freqs[t - 'A']++; // O(n)

        // sort and extract the most frequent task
        Arrays.sort(freqs); // O(log26) = O(1)
        int maxFreq = freqs[25] - 1;
        int maxIdles = maxFreq * n; // calculate the max idle slots

        // traverse the freqs from more frequent (reverse order)
        for (int i = freqs.length - 2; i >= 0; i--) {
            maxIdles -= Math.min(maxFreq, freqs[i]);
        } // O(n)
        maxIdles = Math.max(0, maxIdles); // ensure max idle slots is positive

        return maxIdles + tasks.length;
    }
}
