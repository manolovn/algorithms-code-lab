package dev.manolovn.sentencereverser;

/**
 * Sentence reverser
 * -----------------
 * You are given an array of characters arr that consists of sequences of characters separated by space characters.
 * Each space-delimited sequence of characters defines a word.
 */
public class SentenceReverser {

    /*
      input:  [ 'p', 'e', '  ', 'm', 'a', 'k', 'e', 's' ]
                            ^
      output: [ 'm', 'a', 'k', 'e', 's', '  ', 'p', 'e' ]

      1. adding to another aux array the chars until an space
      2. aux array to the output array

      buffer [1, 1,2,3,43,4,234, ]
                                ^bIdx
      time O(n)
      space O(n)
    */
    static char[] reverseWords(char[] arr) {
        String[] parts = new String(arr).split(" ");
        String[] solution = new String[parts.length];

        if (parts.length == 0) {
            return arr;
        }

        int j = 0;
        for (int i = parts.length - 1; i >= 0; i--) {
            solution[j] = parts[i];
            j++;
        }

        return String.join(" ", solution).toCharArray();
    }
}
