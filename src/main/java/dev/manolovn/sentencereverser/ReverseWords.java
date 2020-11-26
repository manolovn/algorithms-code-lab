package dev.manolovn.sentencereverser;

/**
 * source: https://leetcode.com/problems/reverse-words-in-a-string/
 * difficulty: MEDIUM
 * topic: ARRAY + STRING
 */
public class ReverseWords {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    public String reverseWords(String s) {
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                end = i;
                i = s.lastIndexOf(' ', end);
                sb.append(s, i + 1, end + 1).append(' ');
            }
        }

        return sb.substring(0, sb.length() - 1);
    }

    /**
     * Alternative solution with built-in methods
     * Time:  O(n)
     * Space: O(n)
     */
    public String reverseWords_bultinAlt(String s) {
        s = s.trim();
        String[] parts = s.split("\\s+");
        reverse(parts);
        return String.join(" ", parts);
    }

    private void reverse(String[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            String tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
