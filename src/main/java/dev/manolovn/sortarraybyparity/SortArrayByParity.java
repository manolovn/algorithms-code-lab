package dev.manolovn.sortarraybyparity;

/**
 * source: https://leetcode.com/problems/sort-array-by-parity/
 * difficulty: EASY
 */
public class SortArrayByParity {

    /*
    Approaches:
    - Two passes: create a solution array and two passes over the input A, one for even numbers
    and another one for odd numbers [x]
    - In place: the reorder of input A could be done in place. TODO
    Complexity:
    Time:  O(n) ; the two passes over the input are in separated loops so O(n) + O(n) = O(n)
    Space: O(n) ; due to the solution array
    */
    public int[] sortArrayByParity(int[] A) {
        int[] solution = new int[A.length];
        int si = 0;

        for (int value : A) {
            if (value % 2 == 0) {
                solution[si] = value;
                si++;
            }
        }

        for (int value : A) {
            if (value % 2 != 0) {
                solution[si] = value;
                si++;
            }
        }

        return solution;
    }
}
