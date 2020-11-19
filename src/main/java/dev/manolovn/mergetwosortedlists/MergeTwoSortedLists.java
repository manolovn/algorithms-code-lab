package dev.manolovn.mergetwosortedlists;

import dev.manolovn.common.ListNode;

/**
 * source: https://leetcode.com/problems/merge-two-sorted-lists/
 * difficulty: EASY
 * topic: ARRAYS + LINKED LISTS
 */
public class MergeTwoSortedLists {

    /*
    l1 = [1,2,4], l2 = [1,3]
          ^             ^

    [1,1,2,3,4]
    ^h

    t: O(l1+l2)
    s: O(1)
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;

        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : Integer.MAX_VALUE;
            int b = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (a >= b) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        return ans.next;
    }

    /**
     * Alternative solution using recursion
     */
    public ListNode mergeTwoLists_rec(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists_rec(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_rec(l1, l2.next);
            return l2;
        }
    }
}
