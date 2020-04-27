package dev.manolovn.crackingcodinginterview.ch01

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class URLifyTest(
    private val input: CharArray,
    private val trueLen: Int,
    private val expected: String
) {

    @Test
    fun test() {
        assertEquals(expected, URLify.urlify(input, trueLen))
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: urlify({0})={1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf<Any>("Mr Smith  ".toCharArray(), 8, "Mr%20Smith"),
                arrayOf<Any>("Mr T  ".toCharArray(), 4, "Mr%20T"),
                arrayOf<Any>("Mr John Smith    ".toCharArray(), 13, "Mr%20John%20Smith"),
                arrayOf<Any>("Mr  T    ".toCharArray(), 5, "Mr%20%20T")
            )
        }
    }
}