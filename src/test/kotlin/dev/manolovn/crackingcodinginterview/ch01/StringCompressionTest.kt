package dev.manolovn.crackingcodinginterview.ch01

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class StringCompressionTest(
    private val input: String,
    private val expected: String
) {

    @Test
    fun test() {
        assertEquals(expected, StringCompression.compress(input))
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: compress({0})={1}")
        fun data(): Collection<Array<String>> {
            return listOf(
                arrayOf("abc", "abc"),
                arrayOf("aaaabbc", "a4b2c1"),
                arrayOf("aaaabbcc", "a4b2c2")
            )
        }
    }
}