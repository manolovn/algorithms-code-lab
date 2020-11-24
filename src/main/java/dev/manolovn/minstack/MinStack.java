package dev.manolovn.minstack;

import java.util.Stack;

/**
 * source: https://leetcode.com/problems/min-stack/
 * difficulty: EASY
 * topic: STACK
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * All operations has O(1) in time
     * Space: O(n)
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
