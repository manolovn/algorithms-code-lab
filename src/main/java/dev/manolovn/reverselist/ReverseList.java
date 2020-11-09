package dev.manolovn.reverselist;

import dev.manolovn.common.ListNode;

/**
 * source: https://leetcode.com/problems/reverse-linked-list/
 * difficulty: EASY
 * topic: LISTS
 */
public class ReverseList {

    /**
     * iterative approach
     * time: O(n)
     * space: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    /**
     * recursive approach
     * time: O(n)
     * space: O(n)
     */
    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = reverseList_recursive(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }
}
