package dev.manolovn.queuewithstacks;

import java.util.Stack;

/**
 * source: https://leetcode.com/problems/implement-queue-using-stacks/
 * difficulty: EASY
 * topic: STACK + QUEUE
 */
public class QueueWithStacks {

    private final Stack<Integer> s1;
    private final Stack<Integer> s2;
    int front;

    public QueueWithStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) { // t: O(1); s: O(n)
        if (s1.isEmpty())
            front = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() { // t: O(n); s: O(1)
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() { // t: O(1); s: O(1)
        if (!s2.isEmpty())
            return s2.peek();
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() { // t: O(1); s: O(1)
        return s1.isEmpty() && s2.isEmpty();
    }
}
