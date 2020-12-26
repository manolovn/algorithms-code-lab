package dev.manolovn.topkfrequentnumbers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * source: https://leetcode.com/problems/top-k-frequent-elements/
 * difficulty: MEDIUM
 * topic: HEAP
 */
public class TopKFrequentElements {

    /**
     * Time:  O(nlogk)
     * Space: O(n+k)
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(map::get));
        for (int c : map.keySet()) {
            heap.offer(c);
            if (heap.size() > k) heap.poll();
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
