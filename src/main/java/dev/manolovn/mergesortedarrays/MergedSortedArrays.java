package dev.manolovn.mergesortedarrays;

/**
 * source: https://leetcode.com/problems/merge-sorted-array/
 * difficulty: EASY
 * topics: ARRAYS
 */
public class MergedSortedArrays {

    /*
    #1 : brute force approach: add nums2 to nums1 and sort the array
    Time:  O(nlogn)
    Space: O(n) ; due to the space needed to the sort
    ---
    #2 : two pointers approach:
    [1,2,3,0,0,0]
         ^r1   ^w
    [2,5,6]
         ^r2
    [7,8,9,0,0,0]
         ^r1   ^w
    [2,5,6]
         ^r2
    Time:  O(m+n)
    Space: O(1)
    ---
    #3 : heap approach
    Time:  O((m+n)logn)
    Space: O(n)
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1 = m - 1;
        int r2 = n - 1;
        int w = nums1.length - 1;

        while (r1 >= 0 && r2 >= 0) {
            nums1[w--] = nums2[r2] > nums1[r1] ? nums2[r2--] : nums1[r1--];
        }
        while (r2 >= 0) {
            nums1[w--] = nums2[r2--];
        }
    }
}
