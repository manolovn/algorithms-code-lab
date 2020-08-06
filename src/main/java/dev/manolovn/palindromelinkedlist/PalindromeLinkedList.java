package dev.manolovn.palindromelinkedlist;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * source: https://leetcode.com/problems/palindrome-linked-list
 * difficulty: EASY
 */
public class PalindromeLinkedList {

    /*
    It's important to notice that we want to solve it in O(n) time
    and O(1) space. Without the space limitation, the problem should be easily
    solved using an Stack

    Approach:
    So, to solve it in constant space complexity:
    1. locate the tail of the linked list reversing the list - time: O(n) ; space: O(1)
       1. to locate the tail reversing the list we'll use the tortoise and the hare algorithm
       approach to find the middle point in the list
       2. reverse the middle of the list
    2. keep a pointer to the head and another one to the tail. Move the two pointers
    in different directions; when the values are different and the pointers we could
    ensure that the list is not a palindrome; other cases it's a palindrome - time: O(n) ; space: O(1)
    References:
    - https://farenda.com/algorithms/floyd-cycle-detection-in-java/

    Complexity:
    Given n as the size of the singly-linked list
    Time:  O(n) ; because we need to traverse the full list; O(n) + O(n) = O(2n) = O(n)
    Space: O(1) ; because the space needs are the two pointers no matter the input size
    */
    public boolean isPalindrome(ListNode head) {
        // 1. locate the tail
        ListNode tail = findTail(head);
        // 2. move the tail and head pointers
        while (tail != null) {
            if (tail.val != head.val) {
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    private ListNode findTail(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        return reverse(slow);
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

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
