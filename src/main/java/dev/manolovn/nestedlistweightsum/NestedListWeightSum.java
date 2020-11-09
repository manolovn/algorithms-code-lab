package dev.manolovn.nestedlistweightsum;

import java.util.List;

/**
 * source: https://leetcode.com/problems/nested-list-weight-sum/
 * difficulty: EASY
 * topic: DFS + BFS
 */
public class NestedListWeightSum {
    public interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        void setInteger(int value);

        void add(NestedInteger ni);

        List<NestedInteger> getList();
    }

    /**
     * Time:  O(n)
     * Space: O(H)
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int h) {
        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) sum += ni.getInteger() * h;
            else sum += helper(ni.getList(), h + 1);
        }
        return sum;
    }
}
