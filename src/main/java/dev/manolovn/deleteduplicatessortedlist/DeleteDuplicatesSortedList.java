package dev.manolovn.deleteduplicatessortedlist;

/**
 * source: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * difficulty: EASY
 */
public class DeleteDuplicatesSortedList {

    /**
     * Time:  O(n) ; need to traverse all the list to detect duplicates
     * Space: O(1) ; no need extra data structures
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * Provided by leetcode
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
