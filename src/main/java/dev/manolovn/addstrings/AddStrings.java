package dev.manolovn.addstrings;

/**
 * source: https://leetcode.com/problems/add-strings/
 * difficulty: EASY
 * topic: STRINGS
 */
public class AddStrings {

    /**
     * Time:  O(max(n,m)) ; where n and m are the string lengths
     * Space: O(max(n,m) ; take into account that in languages with immutable strings like Java, this problem
     *                     it's not possible to solve in constant space. A more accurate space complexity analysis
     *                     is O(max(n,m)) + 1
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || sum == 1) {

            sum += i >= 0 ? num1.charAt(i) - '0' : 0;
            sum += j >= 0 ? num2.charAt(j) - '0' : 0;

            sb.insert(0, (char) (sum % 10 + '0'));

            sum /= 10;

            i--;
            j--;
        }

        return sb.toString();
    }
}
