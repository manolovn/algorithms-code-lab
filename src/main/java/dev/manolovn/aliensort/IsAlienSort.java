package dev.manolovn.aliensort;

/**
 * source: https://leetcode.com/problems/verifying-an-alien-dictionary/
 * difficulty: EASY
 * Topics: STRINGS + ARRAYS
 */
public class IsAlienSort {

    /*
    1. create a index map like
        [w] => 0; [o] => 1
    2. compare words in pairs
        - discard words than are equals
        - discard same initial characters in both words
        - take care of "apple-case" where words are like "app" and "apple"
        - compare next character after discard preffixes and lengths
    Time: O(n) ; where n are the total number of characters in words
    Space: O(1)
    */
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) return true;
        // build a map-like with order
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        // compare all words
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i-1], words[i], index)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String l, String r, int[] index) {
        if (l.equals(r)) {
            return true; // discard equals words
        }
        // discard same initial characters in both words
        int min = Math.min(l.length(), r.length());
        int j = 0;
        while (j < min && l.charAt(j) == r.charAt(j)) {
            j++;
        }
        if (j == min) {
            // if j == min, a word is already fully traversed
            return min == l.length();
        } else {
            // if not, just compare characters with our index
            return index[l.charAt(j) - 'a'] < index[r.charAt(j) - 'a'];
        }
    }
}
