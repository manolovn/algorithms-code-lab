package dev.manolovn.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/group-anagrams/
 * difficulty: MEDIUM
 * topic: STRINGS + ARRAYS
 */
public class GroupAnagrams {

    /*
    time:  O(n)
    space: O(1) ; ignoring the map because is needed due to the problem requirements
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) // O(n)
            map.computeIfAbsent(buildKey(str), x -> new ArrayList<>()).add(str);

        return new ArrayList<>(map.values());
    }

    private int buildKey(String str) {
        int[] t = new int[26]; // change order to the charset
        for (int i = 0; i < str.length(); i++) {
            t[str.charAt(i) - 'a']++;
        }
        int key = 0;
        for (int i = t.length - 1; i >= 0; i--) {
            key = key * 10 + t[i];
        }
        return key;
    } // O(1)
}
