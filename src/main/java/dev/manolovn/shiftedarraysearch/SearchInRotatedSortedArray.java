package dev.manolovn.shiftedarraysearch;

/**
 * source: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * difficulty: MEDIUM
 * topic: ARRAYS + BINARY SEARCH
 */
public class SearchInRotatedSortedArray {

    /**
     * Time:  O(logn)
     * Space: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int rp = findRotationPoint(nums);

        if (rp == 0 || target < nums[0]) {
            return search(nums, target, rp, nums.length - 1);
        }
        return search(nums, target, 0, rp - 1);
    }

    private int findRotationPoint(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums[lo] < nums[hi]) return 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[mid] < nums[lo]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return 0;
    }

    private int search(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Alternative solution with just one pass
     * Time:  O(logn)
     * Space: O(1)
     */
    public int search_onePassAlt(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if (target <= nums[hi] && target > nums[mid]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}
