package dev.manolovn.crackingcodinginterview.ch04

/**
 * Write an algorithm to find the "next" node (i.e. in-order successor) of a given node in a BST
 * You may assume that each node has a link to its parent
 */
object Successor {

    /**
     * Time:  O(n) because in the worst case we'll traverse all the tree
     * Space: O(1) we don't need extra data structures
     */
    fun getNextInOrderSuccessor(node: Node): Node? {
        var current: Node? = null
        if (node.right != null) {
            current = node.right
            while (current?.left != null) {
                current = current.left
            }
        } else if (node.parent != null) {
            current = node.parent
            while (current != null && current.value < node.value) {
                current = current.parent
            }
        }
        return current
    }

    data class Node(
        val value: Int,
        val left: Node?,
        val right: Node?,
        val parent: Node?
    )
}