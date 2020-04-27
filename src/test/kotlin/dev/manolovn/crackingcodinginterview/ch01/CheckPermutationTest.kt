package dev.manolovn.crackingcodinginterview.ch01

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class CheckPermutationTest(
    private val input: String,
    private val input2: String,
    private val expected: Boolean
) {

    @Test
    fun test() {
        assertEquals(expected, CheckPermutation.arePermutations(input, input2))
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: arePermutations({0},{1})={2}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("abc", "bca", true),
                arrayOf("aaabc", "abaca", true),
                arrayOf("aaabc", "abac", false),
                arrayOf("ccc", "aaa", false),
                arrayOf("ccaa", "ccab", false)
            )
        }
    }
}