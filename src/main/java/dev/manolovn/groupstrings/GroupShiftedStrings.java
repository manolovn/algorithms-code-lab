package dev.manolovn.groupstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/group-shifted-strings/
 * difficulty: MEDIUM
 * topic: STRINGS
 */
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strings) {
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int relative_distance = (s.charAt(i) - s.charAt(0) + 26) % 26;
                // in case [0,1,11] [0,11,1], so i add "." to key.
                key.append(".").append(relative_distance);
            }
            String k = key.toString();
            map.computeIfAbsent(k, x -> new ArrayList<>()).add(s);
        }

        List<List<String>> output = new ArrayList<>();
        for (String key: map.keySet()) {
            output.add(map.get(key));
        }
        return output;
    }
}
