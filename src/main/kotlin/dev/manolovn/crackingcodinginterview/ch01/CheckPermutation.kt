package dev.manolovn.crackingcodinginterview.ch01

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 */
object CheckPermutation {

    /**
     * First of all, we nee to clarify when an String is a permutation of another one.
     * An String will be a permutation of another one when it contains the same characters
     * with the same frequency. So taking into account that definition, we make the first precondition that
     * is that the String must be with the same length (assuming that we don't need to handle null inputs)
     *
     * We'll assume the input is ASCII
     *
     * (1) To achieve with the question proposal we need a data structure to store the letters and his frequency;
     * in that way we could know when the input Strings are permutations: only when they have the same
     * char frequency distribution
     *
     * Time:  O(n) ; because we use 3 loops O(n) + O(n) = O(n)
     * Space: O(1) ; because the space is constant
     *
     * (2) Another alternative should be to sort the input and compare in one loop character by character. But
     * this approach has lower performance due to the sort
     *
     * Time: O(n log n) ; because the sort
     * Space: O(1) ; because we don't need extra data structures
     *
     * So we'll choose Approach 1
     */
    internal fun arePermutations(a: String, b: String): Boolean {
        if (a.length != b.length) {
            return false
        }
        val charsFreqArr = IntArray(128) // assuming the input is ASCII
        for (c in a.toCharArray()) {
            charsFreqArr[c.toInt()]++
        }
        for (c in b.toCharArray()) {
            charsFreqArr[c.toInt()]--
            if (charsFreqArr[c.toInt()] < 0) {
                return false
            }
        }
        return true
    }
}