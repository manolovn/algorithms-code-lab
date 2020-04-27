package dev.manolovn.crackingcodinginterview.ch01

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class IsUniqueTest(
    private val input: String,
    private val expected: Boolean
) {

    @Test
    fun test() {
        assertEquals(expected, IsUnique.allCharactersAreUnique(input))
        assertEquals(expected, IsUnique.`all characters are unique boolean array alternative`(input))
        assertEquals(expected, IsUnique.`all characters are unique bitmask alternative`(input))
        assertEquals(expected, IsUnique.`all characters are unique without extra data structure`(input))
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: allCharactersAreUnique({0})={1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("daBc", true),
                arrayOf("daBcd", false),
                arrayOf("daBce", true),
                arrayOf("az", true),
                arrayOf("a", true),
                arrayOf("ababababcc", false)
            )
        }
    }
}