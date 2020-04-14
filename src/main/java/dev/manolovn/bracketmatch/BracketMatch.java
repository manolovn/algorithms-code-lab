package dev.manolovn.bracketmatch;

import java.util.Stack;

public class BracketMatch {

    /*
      (()  : 1 --> open open close
      (()) : 0 --> open open close close
      ())( : 2 --> open close close open

      stack [1] - 0 opsCount : 1 + 1


      time O(n)
      space O(n)
    */
    static int bracketMatch(String t) {
        Stack<Boolean> stack = new Stack<>();
        int ops = 0;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '(') {
                stack.push(true);
            } else if (t.charAt(i) == ')') {
                if (stack.empty()) {
                    ops++;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() + ops;
    }
}
