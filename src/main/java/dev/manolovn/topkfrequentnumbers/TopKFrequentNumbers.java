package dev.manolovn.topkfrequentnumbers;

import java.util.*;

/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 * <p>
 * Example:
 * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
 * Output: [12, 11]
 * Explanation: Both '11' and '12' appeared twice
 * <p>
 * difficulty: MEDIUM
 * topics: HEAP
 */
public class TopKFrequentNumbers {

    /**
     * Time:  O(nlogk)
     * Space: O(n + k)
     */
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        // create freq map
        Map<Integer, Integer> fMap = new HashMap<>();
        for (int n : nums) {
            fMap.put(n, fMap.getOrDefault(n, 0) + 1);
        } // O(n)
        // feed the heap
        PriorityQueue<Number> heap = new PriorityQueue<>(k, (a, b) -> a.freq - b.freq);
        for (Map.Entry<Integer, Integer> entry : fMap.entrySet()) {
            heap.offer(new Number(entry.getKey(), entry.getValue()));
            if (heap.size() > k) {
                heap.poll();
            }
        } // O(nlogk)
        // read the heap
        List<Integer> topNumbers = new ArrayList<>(k);
        while (!heap.isEmpty()) {
            topNumbers.add(heap.poll().number);
        } // O(k)
        return topNumbers;
    }

    static class Number {
        int number;
        int freq;

        Number(int number, int freq) {
            this.number = number;
            this.freq = freq;
        }
    }
}
