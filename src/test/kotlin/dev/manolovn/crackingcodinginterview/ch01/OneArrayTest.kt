package dev.manolovn.crackingcodinginterview.ch01

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class OneArrayTest(
    private val input: String,
    private val input2: String,
    private val expected: Boolean
) {

    @Test
    fun test() {
        assertEquals(expected, OneArray.oneEditDistanceAtMost(input, input2))
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: oneEditDistanceAtMost({0},{1})={2}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("pale", "ple", true),
                arrayOf("pales", "pale", true),
                arrayOf("pale", "bale", true),
                arrayOf("pale", "bake", false),
                arrayOf("pale", "p", false),
                arrayOf("pale", "paleses", false),
                arrayOf("p", "peo", false),
                arrayOf("pale", "apale", true)
            )
        }
    }
}