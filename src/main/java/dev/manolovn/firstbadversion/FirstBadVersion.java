package dev.manolovn.firstbadversion;

/**
 * source: https://leetcode.com/problems/first-bad-version/
 * difficulty: EASY
 * topic: BINARY SEARCH
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /*
      The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
      check source link
    */
    private boolean isBadVersion(int version) {
        return false;
    }
}
