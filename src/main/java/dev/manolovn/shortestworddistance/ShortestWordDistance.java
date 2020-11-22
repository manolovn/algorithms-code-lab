package dev.manolovn.shortestworddistance;

/**
 * source: https://leetcode.com/problems/shortest-word-distance/
 * difficulty: EASY
 * topic: ARRAYS + STRINGS
 */
public class ShortestWordDistance {

    /*
    "practice", "makes", "perfect", "coding", "makes"
     ^
     idx -> j
     idx -> k
     min(|j-k|)

    time:  O(n)
    space: O(1)
    */
    public int shortestDistance(String[] words, String word1, String word2) {
        int j = Integer.MAX_VALUE;
        int k = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                j = i;
                min = Math.min(min, Math.abs(j - k));
            }
            if (words[i].equals(word2)) {
                k = i;
                min = Math.min(min, Math.abs(j - k));
            }
        }
        return min;
    }
}
