package dev.manolovn.subarraysum;

import java.util.HashMap;

/**
 * source: https://leetcode.com/problems/continuous-subarray-sum/
 * difficulty: MEDIUM
 * topic: MATH + ARRAYS
 */
public class CheckSubarraySum {

    /*
    Math behind the approach:
    a % k = x
    b % k = x
    (a - b) % k = x -x = 0
    here a - b = the sum between i and j.
    ---
    [23, 2, 4, 6, 7],  k=6

    { {5:0} {1:1} }

    Time:  O(n)
    Space: O(min(n,k)) ; the map can contain upto min(n,k) different pairings
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            } else map.put(sum, i);
        }

        return false;
    }
}
