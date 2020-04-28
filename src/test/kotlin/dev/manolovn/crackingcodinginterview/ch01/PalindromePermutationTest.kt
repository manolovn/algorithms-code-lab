package dev.manolovn.crackingcodinginterview.ch01

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class PalindromePermutationTest(
    private val input: String,
    private val expected: Boolean
) {

    @Test
    fun test() {
        assertEquals(expected, PalindromePermutation.check(input))
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: check({0})={1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("Tact Coa", true),
                arrayOf("Tact cOa", true),
                arrayOf("d a a", true),
                arrayOf("Tic Tac", false),
                arrayOf("tactcoapapa", true)
            )
        }
    }
}