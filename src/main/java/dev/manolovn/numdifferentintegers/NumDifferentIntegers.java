package dev.manolovn.numdifferentintegers;

import java.util.HashSet;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/number-of-different-integers-in-a-string/
 * difficulty: EASY
 * topic: STRING
 */
public class NumDifferentIntegers {

    /**
     * It's important to notice that we should prevent against the following cases:
     *  - numbers greater than Integer.MAX_VALUE
     *  - numbers with zeroes at beginning like (0002 = 02)
     *  - zeroes (000 = 0)
     * So the solution is to use a Set and StringBuilder to accumulate the numbers
     * taking into account the previous requirements
     *
     * Time:  O(n)
     * Space: O(n)
     */
    public int numDifferentIntegers(String word) {
        Set<String> nums = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                // discard 0s at the beginning
                while (i < word.length() && word.charAt(i) == '0') i++;
                // accumulate the number as string using StringBuilder
                while (i < word.length() && Character.isDigit(word.charAt(i))) sb.append(word.charAt(i++));
                // zeroes
                if (sb.length() == 0) sb.append("0");
                nums.add(sb.toString());
            }
        }
        return nums.size();
    }
}
