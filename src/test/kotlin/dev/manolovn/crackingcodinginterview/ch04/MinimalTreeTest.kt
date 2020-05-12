package dev.manolovn.crackingcodinginterview.ch04

import dev.manolovn.crackingcodinginterview.ch04.MinimalTree.Node
import dev.manolovn.crackingcodinginterview.ch04.MinimalTreeTest.Util.isBST
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class MinimalTreeTest(
    private val input: IntArray
) {

    @Test
    fun test() {
        assertTrue(isBST(MinimalTree.toBST(input)!!))
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: toBST({0})={1}")
        fun data(): Collection<Array<IntArray>> {
            return listOf(
                arrayOf(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                arrayOf(intArrayOf(3, 4, 7, 9)),
                arrayOf(intArrayOf(3, 4)),
                arrayOf(intArrayOf(8))
            )
        }
    }

    object Util {
        fun isBST(root: Node): Boolean = isBSTUtil(root, Int.MIN_VALUE, Int.MAX_VALUE)

        private fun isBSTUtil(node: Node?, min: Int, max: Int): Boolean {
            if (node == null) return true
            return if (node.value < min || node.value > max) {
                false
            } else {
                isBSTUtil(node.left, min, node.value - 1)
                        && isBSTUtil(node.right, node.value + 1, max)
            }
        }
    }
}