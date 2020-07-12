package dev.manolovn.addtwonumbers;

/**
 * source: https://leetcode.com/problems/add-two-numbers/
 * difficulty: MEDIUM
 */
public class AddTwoNumbers {

    /*
    ex1:
    (2 -> 4 -> 3) + (5 -> 6 -> 4)
    7 -> 0 -> 8
    ex2:
    (2 -> 4 -> 3) + (5 -> 6)
    7 -> 0 -> 4

    #1 traverse both lists, carrying with sum carry : time O(l1+l2) space O(max(l1, l2) + 1)

    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = new ListNode(0); // dummy head
        ListNode result = solution;

        int carry = 0;
        while (l1 != null || l2 != null) {
            // calculate the sum
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            // add to solution
            result.next = new ListNode(sum % 10);
            result = result.next;
            // next iteration
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return solution.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
