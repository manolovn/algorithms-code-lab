package dev.manolovn.intersectiontwolinkedlists;

import dev.manolovn.common.ListNode;

/**
 * source: https://leetcode.com/problems/intersection-of-two-linked-lists
 * difficulty: EASY
 * topic: LINKED LIST
 */
public class IntersectionTwoLinkedLists {

    /**
     * It's not an application of the Floyd cycle detection algorithm properly
     * but the inspiration is the same. We will traverse the linked lists making a loop
     * (when the end is reached, return to the head)
     * Time:  O(n + m)
     * Space: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode hare = headA;
        ListNode tortoise = headB;
        while (hare != tortoise) {
            hare = hare == null ? headA : hare.next;
            tortoise = tortoise == null ? headB : tortoise.next;
        }

        return hare;
    }

    /**
     * A more straightforward idea is get the length difference, ignore that difference of size
     * and simple traverse the lists in parallel until the node are the same
     * <p>
     * Time:  O(n + m)
     * Space: O(1)
     */
    public ListNode getIntersectionNode_alternative(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int aLen = getLength(headA);
        int bLen = getLength(headB);
        int padding = Math.abs(aLen - bLen);

        if (bLen > aLen) return getIntersect(padding, headB, headA);
        return getIntersect(padding, headA, headB);
    }

    private ListNode getIntersect(int padding, ListNode pa, ListNode pb) {
        ListNode intersectNode = null;

        while (padding > 0) {
            pa = pa.next;
            padding--;
        }

        while (pa != null && pb != null) {
            if (pa == pb) {
                intersectNode = pa;
                break;
            }
            pa = pa.next;
            pb = pb.next;
        }

        return intersectNode;
    }

    private int getLength(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }
}
