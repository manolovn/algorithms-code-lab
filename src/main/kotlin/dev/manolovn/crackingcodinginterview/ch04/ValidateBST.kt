package dev.manolovn.crackingcodinginterview.ch04

/**
 * Implement a function to check if a binary tree is a binary search tree
 */
object ValidateBST {

    fun isBST(root: Node): Boolean = isBSTRec(root, Int.MIN_VALUE, Int.MAX_VALUE)

    private fun isBSTRec(node: Node?, min: Int, max: Int): Boolean {
        if (node == null) return true
        return if (node.value < min || node.value > max) {
            return false
        } else {
            isBSTRec(node.left, min, node.value - 1)
                    && isBSTRec(node.right, node.value + 1, max)
        }
    }

    data class Node(
        val value: Int,
        val left: Node?,
        val right: Node?
    )
}