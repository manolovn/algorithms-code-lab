package dev.manolovn.crackingcodinginterview.ch01

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
object IsUnique {

    /**
     * The first idea is to use a data structure to track the different characters
     * It could be a Map or a simple boolean array with the input length. With all of them
     * we achieve the same complexity so for simplicity we'll choose Map
     *
     * Time complexity : O(n) ; we just need one pass over the string characters
     * Space complexity: O(n) ; we need an extra data structure that is proportional to the input
     */
    fun allCharactersAreUnique(input: String): Boolean {
        val map = HashMap<Char, Boolean>(input.length)
        for (c in input.toCharArray()) {
            if (map.containsKey(c)) { // contains key method is O(1) in a map
                return false
            }
            map[c] = true
        }
        return true
    }

    /**
     * Another more efficient solution could be to use a bitmask with the size of the charset
     * If we assume that the input is ASCII a simple boolean array of size 128
     * help us to obtain a better complexity in space
     *
     * Time complexity : O(n) ; we just need one pass over the string characters
     * Space complexity: O(1) ; because the space needed is constant
     */
    fun `all characters are unique boolean array alternative`(input: String): Boolean {
        if (input.length > 128) {
            return false
        }
        val flags = BooleanArray(128)
        for (char in input.toCharArray()) {
            if (flags[char.toInt()]) {
                return false
            }
            flags[char.toInt()] = true
        }
        return true
    }

    /**
     * Bitmask alternative reduce the space but it only works for input [a-z]
     */
    fun `all characters are unique bitmask alternative`(input: String): Boolean {
        var bitmask = 0
        for (char in input.toCharArray()) {
            val charInt: Int = char - 'a'
            if ((bitmask and (1 shl charInt)) > 0) {
                return false
            }
            bitmask = bitmask or (1 shl charInt)
        }
        return true
    }

    /**
     * Thinking about the alternative to avoid additional data structure, we could use a brute force
     * approach: traversing the full string on every character looking for that character.
     *
     * That brute force approach will give us a constant space complexity O(1)
     * but a time complexity O(n^2) due to nested loops
     */
    fun `all characters are unique without extra data structure`(input: String): Boolean {
        val inputArr = input.toCharArray()
        for ((i, c) in inputArr.withIndex()) {
            for ((j, b) in inputArr.withIndex()) {
                if (i != j && c == b) {
                    return false
                }
            }
        }
        return true
    }
}