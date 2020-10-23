package dev.manolovn.reversesublist;

/**
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’
 *
 * Difficulty: MEDIUM
 * Topic: LINKED LISTS
 */
public class ReverseSublist {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) {
            return head;
        }

        // move to node p
        ListNode current = head;
        ListNode previous = null;
        for (int i = 0; current != null && i < p - 1; ++i) {
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSubList = current;
        ListNode next;

        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;
        } else {
            head = previous;
        }

        lastNodeOfSubList.next = current;

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
