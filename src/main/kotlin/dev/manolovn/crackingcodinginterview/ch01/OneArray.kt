package dev.manolovn.crackingcodinginterview.ch01

import kotlin.math.abs

/**
 * There are three types of edits that can be performed on strings: insert a character, remove a character
 * or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away
 *
 * Example:
 * pale,    ple     -> true
 * pales,   pale    -> true
 * pale,    bale    -> true
 * pale,    bake    -> false
 */
object OneArray {

    /**
     * the first approach is use an aux variable `maxDifferences = 1` that we'll going down for every
     * difference we found while traversing both strings, but we have different strategies to identify
     * an insertion, deletion o replacement between two string. So we'll use the lengths of these strings
     * to determine the different strategies:
     *  - a < b -> insertion lookup
     *      two pointers traverse both strings, when two characters are different return false; else true
     *  - a > b -> deletion lookup
     *      two pointers traverse both strings, when two characters are different return false; else true
     *  - a = b -> replace lookup
     *      two pointers traverse both strings, when two characters are different return false; else true
     * The difference between the strategies is which string is the reference and how to move the pointers
     *
     * Due that we're taking into account the strings length to determine which strategy is applied, also
     * when the both strings has a different length > 2 characters we should return false
     *
     * Time:  O(n) : one pass is enough
     * Space: O(1) : no extra data structures are needed, just the pointers
     */
    fun oneEditDistanceAtMost(a: String, b: String): Boolean {
        val al = a.length
        val bl = b.length
        if (abs(al - bl) >= 2) {
            return false
        }
        return when {
            al < bl -> insertionLookup(a, b)
            al > bl -> deletionLookup(a, b)
            else -> replaceLookup(a, b)
        }
    }

    /**
     * pales
     * i
     * pale
     * j
     */
    private fun insertionLookup(a: String, b: String): Boolean {
        var threshold = 0
        var i = 0
        var j = 0
        while (i < a.length - 1 || j < b.length - 1) {
            if (threshold > 1) {
                return false
            }
            if (a[i] != b[j]) {
                threshold++
                j++
            } else {
                i++
                j++
            }
        }
        return true
    }

    private fun deletionLookup(a: String, b: String): Boolean = insertionLookup(b, a)

    private fun replaceLookup(a: String, b: String): Boolean {
        var threshold = 0
        var i = 0
        var j = 0
        while (i <= a.length - 1 || j <= b.length - 1) {
            if (threshold > 1) {
                return false
            }
            if (a[i] != b[j]) {
                threshold++
            }
            i++
            j++
        }
        return true
    }
}