package dev.manolovn.strobogrammaticnumber;

import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/strobogrammatic-number/
 * difficulty: EASY
 * topic: ARRAYS
 */
public class StrobogrammaticNumber {

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        map.put(0, 0);

        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            int cl = num.charAt(l) - '0';
            int cr = num.charAt(r) - '0';
            if (!map.containsKey(cl) || cl != map.getOrDefault(cr, -1)) return false;

            l++;
            r--;
        }
        return true;
    }
}
