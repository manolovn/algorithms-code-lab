package dev.manolovn.crackingcodinginterview.ch01

/**
 * Given a string, write a function to check if it as permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words
 *
 * Example:
 * input:  Tact Coa
 * output: true --> permutations that are palindrome: "taco cat", "atco cta",...
 */
object PalindromePermutation {

    /**
     * In this case we'll assume that our input is ASCII
     * If we store all characters and his frequency, in the case that we're handling a palindrome
     * the distribution should contains string.length - 1 characters with %2=0 frequency and just one
     * or not with frequency 1 or %2=1. With this approach, we just need a loop and an extra array with
     * ascii values size
     *
     * Time: O(n) ; due to the one pass over the input
     * Space: O(1); due to the constant size of the data structure
     *
     * Another approach will work with the same complexity but with obvious less memory because it is
     * based into using a bit vector instead of the charFreq map
     */
    fun check(input: String): Boolean {
        val charFreq = IntArray(26)

        // build frequency map, it could be extracted to a method
        for (c in input.toCharArray()) {
            if (c == ' ') { // we don't care about spaces
                continue
            }
            if (charFreq[c.toNumericValue()] > 0) {
                charFreq[c.toNumericValue()]--
            } else {
                charFreq[c.toNumericValue()]++
            }
        }

        // fold the frequency map
        var t = 0
        for (c in charFreq) {
            t += c
        }

        return t <= 1
    }

    // tricky: getNumericValue returns a value from 10 to 35 to Aa-Zz characters
    private fun Char.toNumericValue(): Int = Character.getNumericValue(this) - 10
}