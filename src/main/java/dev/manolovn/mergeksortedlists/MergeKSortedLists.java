package dev.manolovn.mergeksortedlists;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    /**
     * Time:  O(nlogk)
     * Space: O(k)
     */
    public static ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (ListNode root : lists) {
            heap.offer(root);
        }
        ListNode head = null;
        ListNode tail = null;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return head;
    }

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
