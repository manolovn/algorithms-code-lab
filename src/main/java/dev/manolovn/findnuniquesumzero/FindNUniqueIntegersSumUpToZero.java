package dev.manolovn.findnuniquesumzero;

/**
 * Find N Unique Integers Sum up to Zero
 * <p>
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * <p>
 * Example:
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * <p>
 * source: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * difficulty: EASY
 */
public class FindNUniqueIntegersSumUpToZero {

    /*
    Approach:
    We need to find n unique integers that sum zero.
    The first idea is thinking in a symmetric range (-x,x)
    In the examples the output is sorted but it's not explicitly specified
    so we can assume that it's not a requirement
    The idea is divide the input and going adding numbers to the solution array
    following the rule of adding the negative m (where m = n/2) and decreasing m on every
    iteration until m is negative

    Complexity:
    Time:  O(n) ; where n is the input. we need to traverse the generated output array
    Space: O(n) ; where n is the input. due to the array output build
    */
    public int[] sumZero(int n) {
        int[] solution = new int[n];

        int m = n / 2;
        int i = 0;
        while (m > 0) {
            solution[i++] = -m;
            solution[i++] = m--;
        }

        // add a zero when the input is odd
        if (n % 2 != 0) {
            solution[i] = 0;
        }

        return solution;
    }
}
