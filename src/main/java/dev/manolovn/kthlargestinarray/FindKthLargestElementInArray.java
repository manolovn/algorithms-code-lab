package dev.manolovn.kthlargestinarray;

import java.util.PriorityQueue;

/**
 * source: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * difficulty: MEDIUM
 * topic: HEAP
 * to improve solution: https://en.wikipedia.org/wiki/Quickselect
 */
public class FindKthLargestElementInArray {

    /*
    #1: sort and get[kth] element
    t: O(nlogn) s: O(n)
    ---
    #2: heap
    t: O(nlogk) s: O(k)

    */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (num > heap.peek()) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        return heap.poll();
    }
}
