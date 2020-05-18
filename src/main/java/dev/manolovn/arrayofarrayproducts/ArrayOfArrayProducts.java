package dev.manolovn.arrayofarrayproducts;

public class ArrayOfArrayProducts {

    /**
     * Following the example:
     *  input: [ 8, 10,  2]
     * output: [20, 16, 80]
     *
     * The solution is make a two passes over the array to obtain O(n) + O(n) = O(n) complexity in time
     * and avoiding a O(n^2) time complexity of a brute force solution.
     * These two passes needs to be done in left-right order and right-left order and be aware of the indexes
     * because we need to start from the index=1 in left-right traversing and from index=(len-1)-1 in
     * right-left traversing
     *
     * Time:  O(n) ; because the two passes over the array in separated loops
     * Space: O(1) ; because the changes are done in place
     */
    static int[] arrayOfArrayProducts(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return new int[]{};
        }

        int len = arr.length;
        int[] result = new int[len];
        result[0] = 1;

        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        int aux = 1;
        for (int i = len - 2; i >= 0; i--) {
            aux *= arr[i + 1];
            result[i] *= aux;
        }

        return result;
    }
}
