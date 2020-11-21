package dev.manolovn.shortestwordeditpath;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestWordEditPath {

    /**
     * Time:  O(n*L) ; where n is the length of words
     *                 and L is the max length of the words
     * Space: O(n)
     */
    static int shortestWordEditPath(String source, String target, String[] words) {
        int distance = 0;

        Queue<String> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String c = q.poll();
                if (target.equals(c)) {
                    return distance;
                }
                for (int i = 0; i < words.length; i++) {
                    String w = words[i];
                    if (w != null && haveDistanceOne(w, c)) {
                        q.add(w);
                        words[i] = null;
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    private static boolean haveDistanceOne(String a, String b) {
        if (a.length() != b.length()) return false;
        int diffs = 0;
        int i = 0;
        int j = 0;

        while (i < a.length() || j < b.length()) {
            char ca = (i < a.length()) ? a.charAt(i) : '\u0000';
            char cb = (j < b.length()) ? b.charAt(j) : '\u0000';
            if (ca != cb) diffs += 1;
            if (diffs > 1) break;
            i++;
            j++;
        }

        return diffs <= 1;
    }
}
