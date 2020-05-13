package dev.manolovn.crackingcodinginterview.ch04

import kotlin.Int.Companion.MIN_VALUE
import kotlin.math.abs
import kotlin.math.max

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of this question,
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node
 * never differ by more than one
 */
object CheckBalanced {

    /**
     * we'll extract depth of every branch, the tree will be balanced if they doesn't differ by more than one
     * we could do in parallel to improve the solution performance
     *
     * Time:  O(n) we need to traverse all the tree
     * Space: O(H) with H as the tree height
     */
    fun checkBalanced(root: Node): Boolean = getHeight(root) != MIN_VALUE

    private fun getHeight(root: Node?): Int {
        if (root == null) return -1

        val leftH = getHeight(root.left)
        if (leftH == MIN_VALUE) return MIN_VALUE

        val rightH = getHeight(root.right)
        if (rightH == MIN_VALUE) return MIN_VALUE

        if (abs(leftH - rightH) > 1) {
            return MIN_VALUE
        }
        return max(leftH, rightH) + 1
    }

    data class Node(
        val left: Node?,
        val right: Node?
    )
}