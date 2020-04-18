package dev.manolovn.abbreviation

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class AbbreviationTest(
    private val input: String,
    private val input2: String,
    private val expected: String
) {

    @Test
    fun test() {
        assertEquals(expected, Abbreviation.abbreviation(input, input2))
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: abbreviation({0},{1})={2}")
        fun data(): Collection<Array<String>> {
            return listOf(
                arrayOf("daBcd", "ABC", "YES"),
                arrayOf("Pi", "P", "YES"),
                arrayOf("AfPZN", "APZNC", "NO"),
                arrayOf("LDJAN", "LJJM", "NO"),
                arrayOf("UMKFW", "UMKFW", "YES"),
                arrayOf("KXzQ", "K", "NO"),
                arrayOf("LIT", "LIT", "YES"),
                arrayOf("QYCH", "QYCH", "YES"),
                arrayOf("DFIQG", "DFIQG", "YES"),
                arrayOf("sYOCa", "YOCN", "NO"),
                arrayOf("JHMWY", "HUVPW", "NO")
            )
        }
    }
}