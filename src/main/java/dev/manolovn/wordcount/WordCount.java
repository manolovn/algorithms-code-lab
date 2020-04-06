package dev.manolovn.wordcount;

import java.util.*;
import java.util.Map.Entry;

public class WordCount {

    private static final String DELIMITER = " ";

    static String[][] wordCountEngine(String document) {
        Map<String, Count> wordCount = new LinkedHashMap<>();
        String[] words = document.split(DELIMITER);

        for (int i = 0; i < words.length; i++) {
            String word = sanitize(words[i]);
            if (wordCount.containsKey(word)) {
                Count tmp = wordCount.get(word);
                tmp.count += 1;
                wordCount.put(word, tmp);
            } else {
                Count c = new Count();
                c.order = i;
                c.count += 1;
                wordCount.put(word, c);
            }
        }

        // Sort the map
        wordCount = sortMap(wordCount);

        // Build the output
        String[][] solution = new String[wordCount.keySet().size()][];
        int solIdx = 0;
        for (Entry<String, Count> entry : wordCount.entrySet()) {
            solution[solIdx] = new String[]{entry.getKey(), entry.getValue().count.toString()};
            solIdx++;
        }

        return solution;
    }

    private static String sanitize(String word) {
        return removePunctuationSigns(word.toLowerCase());
    }

    private static String removePunctuationSigns(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }

    private static Map<String, Count> sortMap(Map<String, Count> map) {
        List<Entry<String, Count>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<String, Count> result = new LinkedHashMap<>();
        for (Entry<String, Count> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    // implements Comparable<Count>
    private static class Count implements Comparable<Count> {
        Integer order = 0;
        Integer count = 0;

        public Count() {

        }

        @Override
        public String toString() {
            return "[" + order + " -> " + count + "]";
        }

        @Override
        public int compareTo(Count other) {
            int counts = other.count.compareTo(this.count);
            if (counts == 0) {
                return this.order.compareTo(other.order);
            }
            return counts;
        }
    }
}
