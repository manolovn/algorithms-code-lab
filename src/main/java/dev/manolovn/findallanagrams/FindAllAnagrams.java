package dev.manolovn.findallanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * source: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * difficulty: MEDIUM
 * topic: STRINGS + ANAGRAMS + HASHMAP
 */
public class FindAllAnagrams {

    /*
    s: "cbaebabacd" p: "abc"

    #1: map approach
     - put abc in map { character -> freq} --> { a : 0, b : 0, c : 0 }
     - traverse s
     cbaebabacd
       ^

    Time:  O(s+p)
    Space: O(1) ; because the map is up to 26 pairs
    */
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        int[] pmap = new int[26];
        for (char c : p.toCharArray()) pmap[c - 'a']++;

        int[] smap = new int[26];
        int w = p.length();
        for (int i = 0; i < s.length(); i++) {
            smap[s.charAt(i) - 'a']++;

            if (i >= w) smap[s.charAt(i - w) - 'a']--;

            if (Arrays.equals(smap, pmap)) ans.add(i - w + 1);
        }

        return ans;
    }
}
