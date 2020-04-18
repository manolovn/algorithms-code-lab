package dev.manolovn.battleshipboard

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class BattleshipBoardTest(
    private val input: Array<CharArray>,
    private val expected: Int
) {

    @Test
    fun test() {
        assertEquals(expected.toLong(), BattleshipBoard.countBattleships(input).toLong())
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: countBattleships({0})={1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf<Any>(
                    arrayOf(
                        charArrayOf('X', '.', '.', 'X'),
                        charArrayOf('.', '.', '.', 'X'),
                        charArrayOf('.', '.', '.', 'X')
                    ), 2
                ),
                arrayOf<Any>(
                    arrayOf(
                        charArrayOf('X', '.', '.', 'X'),
                        charArrayOf('.', '.', '.', '.'),
                        charArrayOf('.', '.', '.', 'X')
                    ), 3
                ),
                arrayOf<Any>(
                    arrayOf(
                        charArrayOf('X', 'X', 'X', 'X'),
                        charArrayOf('.', '.', '.', '.'),
                        charArrayOf('X', '.', 'X', 'X')
                    ), 3
                ),
                arrayOf<Any>(
                    arrayOf(
                        charArrayOf('X', 'X', '.', 'X'),
                        charArrayOf('.', '.', 'X', '.'),
                        charArrayOf('X', '.', 'X', '.')
                    ), 4
                ),
                arrayOf<Any>(
                    arrayOf(
                        charArrayOf('X', 'X', '.', 'X'),
                        charArrayOf('.', '.', 'X', '.'),
                        charArrayOf('X', '.', '.', '.')
                    ), 4
                )
            )
        }
    }
}