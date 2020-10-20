package dev.manolovn.startlinkedlistcycle;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

/**
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle
 *
 * Difficulty: MEDIUM
 * Topics: CYCLE DETECTION + LINKED LIST + SLOW/FAST POINTERS
 */
class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        int cycleLength = 0;
        ListNode slow = head.next;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // we found a cycle!
                cycleLength = getCycleLength(slow, fast);
                break;
            }
        }
        return getCycleStartNode(head, cycleLength);
    }

    private static ListNode getCycleStartNode(ListNode head, int len) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (len > 0) {
            p1 = p1.next;
            len--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    private static int getCycleLength(ListNode slow, ListNode fast) {
        int len = 1;
        fast = fast.next;
        while(slow != fast) {
            fast = fast.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
