package dev.manolovn.containerwithwater;

/**
 * source: https://leetcode.com/problems/container-with-most-water/
 * difficulty: MEDIUM
 */
public class ContainerWithMostWater {

    /*
    Approach:
    1.Brute force: the easier approach is to calculate all the possible areas
    keeping the max. Very easy to implement but very expensive in complexity terms
    Time:  O(n^2)
    Space: O(1)
    So this approach is discarded
    2.Two pointers: the idea is to use two pointers: one in the head of the array and another
    one in the tail
    Time:  O(n)
    Space: O(1)
    This is the finally chosen approach
    */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            max = Math.max(max, area(height, right, left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }

    private int area(int[] h, int r, int l) {
        return Math.min(h[r],h[l]) * (r - l);
    }
}
