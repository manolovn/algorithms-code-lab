package dev.manolovn.finddnasequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * source: https://leetcode.com/problems/repeated-dna-sequences/
 * difficulty: MEDIUM
 * topics: STRINGS + HASHMAP
 */
public class FindRepeatedDnaSequence {

    /**
     * Time:  O(L(n-L))
     * Space: O(n)
     * where n is the length of s
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10;
        Set<String> seen = new HashSet<>();
        Set<String> out = new HashSet<>();

        for (int i = 0; i < s.length() - L + 1; i++) {
            String tmp = s.substring(i, i + L); // O(L)
            if (seen.contains(tmp)) out.add(tmp);
            seen.add(tmp);
        }

        return new ArrayList<>(out);
    }
}
