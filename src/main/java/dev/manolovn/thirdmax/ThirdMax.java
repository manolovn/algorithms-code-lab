package dev.manolovn.thirdmax;

import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * source: https://leetcode.com/problems/third-maximum-number/
 * difficulty: EASY
 */
class ThirdMax {

    /*
    Time:  O(n) ; In a PriorityQueue the time complexity is:
                  - contains() is O(n)
                  - [retrieval methods] size(), peek() and poll() are O(1)
                  - [adding methods] offer() is O(log n)
    Space: O(1) ; because the priority queue is always size = 3
    */
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);

        for (int num : nums) {
            if (!pq.contains(num)) {
                pq.offer(num);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }

        // case 3rd maximum doesn't exists
        if (pq.size() < 3) {
            while (pq.size() != 1) {
                pq.poll();
            }
        }

        return pq.peek();
    }

}
