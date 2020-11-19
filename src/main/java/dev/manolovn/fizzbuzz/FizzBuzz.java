package dev.manolovn.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * source: https://leetcode.com/problems/fizz-buzz/
 * difficulty: EASY
 */
public class FizzBuzz {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean is3 = i % 3 == 0;
            boolean is5 = i % 5 == 0;
            String x = "";
            if (is3) {
                x += "Fizz";
            }
            if (is5) {
                x += "Buzz";
            }
            if (!is3 && !is5) {
                x += Integer.toString(i);
            }
            ans.add(x);
        }

        return ans;
    }
}
