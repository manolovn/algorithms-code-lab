package dev.manolovn.replaceArrayRight;

/**
 * source: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class ReplaceArrayRight {

    /*
    Time: O(n)
    Space: O(n)
    How to improve it: do the replacement in-place
    */
    public int[] replaceElements(int[] arr) {
        int[] sol = new int[arr.length];
        int maxR = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            sol[i] = maxR;
            maxR = Math.max(arr[i], maxR);
        }

        return sol;
    }
}
