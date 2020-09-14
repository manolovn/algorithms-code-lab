package dev.manolovn.uniquenumberofocurrences;

import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/unique-number-of-occurrences/
 * difficulty: EASY
 * topic: MAP + ARRAYS
 */
public class UniqueNumberOfOcurrences {

    /*
    1# brute force
    lookup every element in the arr itself
    for e : arr
        for e:arr
    ----
    time:  O(n^2)
    space: O(1)

    2# sort
    sort(arr)
    for e:arr
        if (e[i] == e[i-1]) return false
    return true
    ----
    time:  O(nlogn) + O(n) = O(nlogn)
    space: O(n) // due to sorting

    (*)3# map
    map() = new map()
    create map in a for loop
    for e : map.values
        if e already exists in map return false
    return true
    ----
    time:  O(n) + O(n) = O(2n) = O(n)
    space: O(n) + O(n) = O(2n) = O(n)
    */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] freqs = new int[arr.length];
        for (int e : arr) {
            if (m.containsKey(e)) {
                m.put(e, m.get(e)+1);
            } else {
                m.put(e, 1);
            }
        }
        for (int e : m.values()) {
            if (freqs[e] > 0) return false;
            freqs[e] = 1;
        }
        return true;
    }
}
