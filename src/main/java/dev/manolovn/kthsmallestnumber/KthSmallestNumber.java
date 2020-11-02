package dev.manolovn.kthsmallestnumber;

import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find Kth smallest number in it
 * <p>
 * Example:
 * Input: [1, 5, 12, 2, 11, 5], K = 3
 * Output: 5
 * Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2]
 * <p>
 * difficulty: EASY
 * topics: HEAPS
 */
public class KthSmallestNumber {

    /**
     * Time:  O(nlogk)
     * Space: O(k)
     */
    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }
        return maxHeap.poll();
    }
}
