package dev.manolovn.movezerostoend;

/**
 * Move zeros to end
 * -----------------
 * Given an array of integers, move all zeroes in the array to the end of the array
 * Preserve the relative order of items in the array
 *
 * For example:
 * input:  [1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0]
 * output: [1, 10, 2, 8, 3, 6, 4, 5, 7, 0, 0, 0, 0, 0]
 */
public class MoveZerosToEnd {

    static int[] moveZerosToEnd(int[] arr) {
        int[] solution = new int[arr.length];
        int j = 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] != 0) {
                solution[j] = arr[i];
                j++;
            }
        }

        while (j <= arr.length - 1) {
            solution[j] = 0;
            j++;
        }

        return solution;
    }
}
