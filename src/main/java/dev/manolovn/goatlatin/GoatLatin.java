package dev.manolovn.goatlatin;

/**
 * source: https://leetcode.com/problems/goat-latin/
 * difficulty: EASY
 * topic: STRINGS
 */
public class GoatLatin {

    /**
     * Time:  O(n^2)
     * Space: O(n^2)
     */
    public String toGoatLatin(String s) {
        StringBuilder output = new StringBuilder();
        String[] words = s.split(" ");
        String suff = "";

        for (String word : words) {
            suff += 'a'; // Java compiler converts this into a temporary StringBuilder
            if (isVowel(word.charAt(0))) {
                output.append(word).append("ma");
            } else {
                output.append(word.substring(1))
                        .append(word.charAt(0))
                        .append("ma");
            }
            output.append(suff).append(" ");
        }

        return output.substring(0, output.length() - 1);
    }

    private boolean isVowel(char c) {
        return "aAeEiIoOuU".indexOf(c) >= 0;
    }
}
