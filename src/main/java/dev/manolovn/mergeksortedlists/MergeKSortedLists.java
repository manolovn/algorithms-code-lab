package dev.manolovn.mergeksortedlists;

import dev.manolovn.common.ListNode;

import java.util.PriorityQueue;

/**
 * source: https://leetcode.com/problems/merge-k-sorted-lists/
 * difficulty: HARD
 * topic: HEAP + LINKED LISTS
 */
public class MergeKSortedLists {

    /**
     * Time:  O(nlogk)
     * Space: O(k)
     */
    public static ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
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

    /*
    The approach is to use a heap to track the minimum value of every list,
    so we create a heap and store the k head ListNodes.
    After that, we only need to poll to the heap and move the next pointers
    to the next node when exists
    Time:  O(nlogk)
    Space: O(k)
    ---
    Another easy and optimal approach could be merge the lists 2 by 2 like
    https://leetcode.com/problems/merge-two-sorted-lists/
    */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode pointer = head;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode ln : lists)
            if (ln != null) heap.offer(ln);

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            pointer.next = node;
            pointer = pointer.next;
            node = node.next;
            if (node != null)
                heap.offer(node);
        }

        return head.next;
    }
}
