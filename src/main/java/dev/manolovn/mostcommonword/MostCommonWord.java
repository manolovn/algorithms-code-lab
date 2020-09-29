package dev.manolovn.mostcommonword;

import java.util.*;

/**
 * source: https://leetcode.com/problems/most-common-word/
 * difficulty: EASY
 * topics: STRING
 */
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        // 1. create map with banned
        Set<String> ban = new HashSet<>();
        Collections.addAll(ban, banned);

        Map<String, Integer> frequencyMap = new HashMap<>(); // frequency map
        // 2. extract words from paragraph
        String[] words = paragraph.replaceAll("\\W", " ").split(" ");

        String mostCommonWord = "";
        int maxFrequency = 0;
        for (String word : words) {
            String wa = word.toLowerCase().trim();
            if (!ban.contains(wa) && !wa.equals("")) { // if not banned
                int c = frequencyMap.getOrDefault(wa, 0) + 1;
                if (c > maxFrequency) {
                    mostCommonWord = wa;
                    maxFrequency = c;
                }
                frequencyMap.put(wa, c);
            }
        }
        return mostCommonWord;
    }
}
