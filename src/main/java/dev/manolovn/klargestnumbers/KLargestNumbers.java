package dev.manolovn.klargestnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it
 * <p>
 * Example:
 * Input: [3, 1, 5, 12, 2, 11], K = 3
 * Output: [5, 12, 11]
 * <p>
 * difficulty: EASY
 * topics: HEAP
 */
public class KLargestNumbers {

    /**
     * Time:  O(nlogk)
     * Space: O(k)
     */
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        } // O(nlogk)
        return new ArrayList<>(heap);
    }
}
