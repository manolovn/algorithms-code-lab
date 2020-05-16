package dev.manolovn.crackingcodinginterview.ch04

import dev.manolovn.crackingcodinginterview.ch04.BuildOrder.getBuildOrderForProjects
import org.junit.Assert.assertArrayEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import java.util.*

@RunWith(Parameterized::class)
class BuildOrderTest(
    private val input: Array<String>,
    private val input2: Array<Pair<String, String>>,
    private val expected: Array<String>
) {

    @Test
    fun test() {
        assertArrayEquals(getBuildOrderForProjects(input, input2).toProjectsNameArray(), expected)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: getBuildOrderForProjects({0},{1})={2}")
        fun data(): Collection<Array<Any>> {
            return arrayListOf(
                arrayOf<Any>(
                    arrayOf("a", "b", "c", "d", "e", "f"),
                    arrayOf(
                        Pair("a", "d"), Pair("f", "b"), Pair("b", "d"), Pair("f", "a"), Pair("d", "c")
                    ),
                    arrayOf("f", "e", "b", "a", "d", "c")
                )
            )
        }
    }
}

private fun Stack<Project>.toProjectsNameArray(): Array<String>? = asReversed().map { it.name }.toTypedArray()
