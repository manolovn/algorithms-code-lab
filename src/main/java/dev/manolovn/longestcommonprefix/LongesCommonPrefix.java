package dev.manolovn.longestcommonprefix;

/**
 * source: https://leetcode.com/problems/longest-common-prefix/
 * difficulty: EASY
 * topic: ARRAY + STRING
 */
public class LongesCommonPrefix {

    /*
    ["flower","flow","flight"]

    where n is the total number of characters in the strings (strings * length)
    #1: vertical scanning ; time = O(n) ; space = O(1)
    #2: binary search; time = O(nlog(string length)) ; space = O(1)

    scalability idea: using trie
    */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
