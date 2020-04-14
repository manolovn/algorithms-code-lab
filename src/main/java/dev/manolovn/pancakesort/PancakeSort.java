package dev.manolovn.pancakesort;

public class PancakeSort {

    /*
      1. flip(arr, k)
      [1, 5, 4, 3, 2] k = 1
             ^
      [4, 5, 1, 3, 2]
          ^

      loop k..k/2
        // todo: to make the swap in place
        arr[k] -> arr[0]
        arr[0] -> arr[k]

      2. pancakeSort(arr) : quick sort
        [1, 5, 3, 4, 2]
            ^
        [5, 1, 3, 4, 2]

        [2, 4, 3, 1, 5]
                  ^

        2.1 find max value
          for i in 0..arr.lenght
           max = find(arr - 1)
           flip(arr, pos(max))
           flip (arr, k)
    */
    public static int[] pancakeSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = arr.length - 1 - i;
            int max = getMax(arr, k);
            flip(arr, max);
            flip(arr, k);
        }
        return arr;
    }

    /**
     * Returns the max index with max value in arr in the first k elements
     */
    static int getMax(int[] arr, int k) {
        int maxIdx = 0;
        int max = arr[0];
        for (int i = 1; i <= k; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static void flip(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            int swap = arr[k];
            arr[k] = arr[i];
            arr[i] = swap;
            k--;
        }
    }
}
