package dev.manolovn.connectropes;

import java.util.PriorityQueue;

/**
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 * <p>
 * Example:
 * Input: [1, 3, 11, 5]
 * Output: 33
 * Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
 * <p>
 * difficulty: EASY
 * topics: HEAPS
 */
public class ConnectRopes {

    /**
     * Time:  O(nlogn)
     * Space: O(n)
     */
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropeLengths) {
            minHeap.offer(rope);
        }
        int cost = 0;
        while (minHeap.size() > 1) {
            int tmp = minHeap.poll() + minHeap.poll();
            cost += tmp;
            minHeap.offer(tmp);
        }
        return cost;
    }
}
