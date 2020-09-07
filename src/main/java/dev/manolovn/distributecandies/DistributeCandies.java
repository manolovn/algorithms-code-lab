package dev.manolovn.distributecandies;

import java.util.HashSet;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/distribute-candies/
 * difficulty: EASY
 */
public class DistributeCandies {

    /*
    The approach is just use a set to keep the different candies for the sister
    and return the min(set size, candies length/2) because the set size is the
    the max number of candies that sister can obtain when there are enough unique candies
    or the candies size / 2 when not.
    This approach is to obtain the better solution in time, other solutions like
    sorting will achieve better space complexity but worse time

    Time:  O(n)
    Space: O(n)
    */
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }
        return Math.min(set.size(), candies.length/2);
    }
}
