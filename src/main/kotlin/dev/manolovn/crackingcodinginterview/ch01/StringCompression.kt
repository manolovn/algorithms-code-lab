package dev.manolovn.crackingcodinginterview.ch01

import java.lang.StringBuilder

/**
 * Implement a method to perform a basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would became a2b1c5a3. If the "compressed" string would not became
 * smaller than the original one, your method should return the original string. You can assume has only
 * uppercase and lowercase letters (a-z)
 */
object StringCompression {

    /**
     * The idea is very simple, one pass over the input characters counting up when a char is equal to previous
     * and building the string output at same time.
     * We must to take care of concatenation in strings inside a loop, so we'll use a StringBuilder
     *
     * Time:  O(n) ; just one pass, StringBuilder.append is O(1)
     * Space: O(n) : due to output string
     *
     * We could improve the actual solution if we check before construct the compression if it will be longer
     * than input. With that optimization we avoid sometimes the extra space needed to build the output
     */
    fun compress(input: String): String {
        val stringBuilder = StringBuilder()
        var count = 1

        for ((i, c) in input.toCharArray().withIndex()) {
            if (i + 1 >= input.length || c != input[i + 1]) {
                stringBuilder.append(c).append(count)
                count = 0
            }
            count++
        }

        return if (stringBuilder.length < input.length) stringBuilder.toString() else input
    }
}