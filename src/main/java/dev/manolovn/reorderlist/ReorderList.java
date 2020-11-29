package dev.manolovn.reorderlist;

import dev.manolovn.common.ListNode;

/**
 * source: https://leetcode.com/problems/reorder-list/
 * difficulty: MEDIUM
 * topic: LINKED LISTS
 */
public class ReorderList {

    /*
    1->2->3->4->5   5->4
          ^            ^

    1. middle of list
    2. reverse the midle of the list
    3. merge two sorted lists

    1->5->2->4->3

    Time:  O(n)
    Space: O(1)
    */
    public void reorderList(ListNode head) {
        if (head == null) return;

        // 1. find middle of linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // here slow is in the middle of the list

        // 2. reverse the rightside part of the list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // here we have the right-side of the list reverted

        // 3. merge two sorted lists
        ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}
