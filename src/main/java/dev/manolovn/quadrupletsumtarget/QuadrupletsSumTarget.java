package dev.manolovn.quadrupletsumtarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
 * whose sum is equal to the target number.
 *
 * Example:
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 *
 * Difficulty: MEDIUM
 * Topics: ARRAYS + TWO POINTERS
 */
public class QuadrupletsSumTarget {

    /**
     * The approach is similar to the two pointers pattern but using two extra pointers to transform the problem
     * into a simplest two pointers problem.
     * [4, 1, 2, -1, 1, -3]
     *  |  |
     *  a  b
     * The pointers a and b will traverse the arr input like two "pivots", the rest of the array will be like
     * a subproblem of two pointers.
     * [4, 1, 2, -1, 1, -3]
     *        |          |
     *        c          d
     * To obtain a valid solution using this idea we need to sort previously the input, this will not impact on the
     * time complexity of the solution because the rest of the implementation will obtain a significally more
     * relevant complexity
     * The subproblem with two pointers is solved in the function "searchPairs"
     *
     * Time:  O(nlogn) + O(n^3) = O(n^3)
     * Space: O(n) ; due to the sorting requirement
     */
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr); // O(nlogn)
        List<List<Integer>> quadruplets = new ArrayList<>();

        for (int a = 0; a < arr.length - 3; a++) {
            if (a > 0 && arr[a] == arr[a-1])
                continue; // to avoid duplicates
            for (int b = a+1; b < arr.length - 2; b++) {
                if (b > a+1 && arr[b] == arr[b-1])
                    continue; // to avoid duplicates
                searchPairs(arr, target, a, b, quadruplets); // O(n)
            }
        } // O(n^3)

        return quadruplets;
    } // O(nlogn) + O(n^3) = O(n^3)

    private static void searchPairs(int[] arr, int target, int a, int b, List<List<Integer>> quadruplets) {
        int c = b+1;
        int d = arr.length - 1;
        while (d > c) {
            int currentSum = arr[a] + arr[b] + arr[c] + arr[d];
            if (currentSum == target) {
                quadruplets.add(Arrays.asList(arr[a], arr[b], arr[c], arr[d]));
                c++;
                d--;
                while (d > c && arr[c] == arr[c+1])
                    c++; // to avoid duplicates
                while (d > c && arr[d] == arr[d-1])
                    d--; // to avoid duplicates
            } else if (currentSum > target) {
                d--;
            } else {
                c++;
            }
        }
    }
}
