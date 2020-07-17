package dev.manolovn.reversevowels;

/**
 * source: https://leetcode.com/problems/reverse-vowels-of-a-string
 * difficulty: EASY
 */
public class ReverseVowels {

    /*
    Possible approaches:
    - two pointers: a pointer from beginning and another one from the end of the string
    when the two pointers are in a vowel, swap and repeat until the two pointers are
    together
    - stack: traverse from the end to the beginning extracting the vowels to an stack and
    then traverse from beginning to end extracting from the stack and chaning the vowels
    Approach selected:
    - two pointers
    Complexity:
    Given n as the length of the input string
    Time:  O(n) ; because the string should be traversed
    Space: O(1) ; the space needed is constant
    */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0; // left side pointer
        int r = s.length() - 1; // right side pointer

        while (l < r) {
            boolean lVowel = isVowel(chars[l]);
            boolean rVowel = isVowel(chars[r]);

            if (lVowel && rVowel) {
                swap(chars, l, r);
            } else if (rVowel) {
                r++;
            } else if (lVowel) {
                l--;
            }

            l++;
            r--;
        }

        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
                || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
}
