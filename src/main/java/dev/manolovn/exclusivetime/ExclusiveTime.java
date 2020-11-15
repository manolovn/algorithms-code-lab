package dev.manolovn.exclusivetime;

import java.util.List;
import java.util.Stack;

/**
 * source: https://leetcode.com/problems/exclusive-time-of-functions/
 * difficulty: MEDIUM
 * topic: STACK
 */
public class ExclusiveTime {

    /**
     * Time:  O(n)
     * Space: O(n) ; the stack can grow upto n/2
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1;
        int prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }

        return res;
    }
}
