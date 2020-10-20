package dev.manolovn.middlelinkedlist;

/**
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList
 * <p>
 * Difficulty: EASY
 * Topics: LINKED LIST + FAST/SLOW POINTERS
 */
class MiddleLinkedList {

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
