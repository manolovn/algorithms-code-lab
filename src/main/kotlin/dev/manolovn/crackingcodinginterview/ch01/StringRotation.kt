package dev.manolovn.crackingcodinginterview.ch01

/**
 * String rotation problem
 * Assume you have a method "isSubstring" which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.
 * eg. "waterbottle" is a rotation of "erbottlewat"
 *
 * Questions to clarify with interviewer:
 * - What about upper/lowercase?
 * - What about whitespaces?
 */
object Main {
    /**
     * Complexity
     * Time:  O(2a) = O(a)
     * Space: O(a+b)
     */
    fun solve(a: String, b: String): Boolean {
        // preconditions
        return if (a.length != b.length) false else (a + a).contains(b)
    }

    fun main(args: Array<String>) {
        println(solve("waterbottle", "erbottlewat"))
        println(solve("water bottle", "er bottlewat"))
        println(solve("waterbottle", "erbottlewAt"))
        println(solve("waterbottle", "erbottlewa"))
        println(solve("waterbottle", "erbottlewet"))
    }
}