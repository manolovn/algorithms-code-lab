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
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            // find the leftmost vowel
            while (i < s.length() && !isVowel(chars[i])) {
                i++;
            }
            // find the rightmost vowel
            while (j >= 0 && !isVowel(chars[j])) {
                j--;
            }
            if (i < j) {
                swap(chars, i, j);
                i++;
                j--;
            }
        }

        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return "aAeEiIoOuU".indexOf(c) >= 0;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }
}
