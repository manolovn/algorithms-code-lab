package dev.manolovn.findsortedrange;

/**
 * source: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * difficulty: MEDIUM
 * topic: BINARY SEARCH + ARRAY
 */
public class FindRange {

    /**
     * Time:  O(logn)
     * Space: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] { -1, -1 };
        range[0] = find(nums, target, true);
        range[1] = find(nums, target, false);
        return range;
    }

    private int find(int[] nums, int target, boolean isStart) {
        int idx = -1;
        // binary search
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                idx = mid;
                if (isStart) hi = mid - 1;
                else lo = mid + 1;
            }
        }
        return idx;
    }
}
