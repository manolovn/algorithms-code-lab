package dev.manolovn.nextletter;

/**
 * Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array
 * greater than a given ‘key’.
 * Assume the given array is a circular list, which means that the last letter is assumed to be connected
 * with the first letter. This also means that the smallest letter in the given array is greater than the
 * last letter of the array and is also the first letter of the array.
 *
 * Example:
 * Input: ['a', 'c', 'f', 'h'], key = 'f'
 * Output: 'h'
 * Explanation: The smallest letter greater than 'f' is 'h' in the given array
 *
 * difficulty: MEDIUM
 * topics: BINARY SEARCH
 */
public class NextLetter {

    /**
     * Time:  O(logn)
     * Space: O(1)
     */
    public static char searchNextLetter(char[] letters, char key) {
        int n = letters.length;

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % n];
    }
}
