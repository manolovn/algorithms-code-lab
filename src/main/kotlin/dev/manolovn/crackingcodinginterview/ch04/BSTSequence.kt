package dev.manolovn.crackingcodinginterview.ch04

import java.util.*

/**
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 *
 * Example:
 *     2
 *    / \
 *   1  3
 *
 * Output: {2,1,3}, {2,3,1}
 */
object BSTSequence {

    /**
     * The idea is create different arrays while traversing the tree using a BFS
     * So, for the first iteration we'll obtain two arrays (root, right, left) and (root, left, right)
     * And repeat this operation while going deeper in the tree
     *     2
     *    / \
     *   1  3
     *
     * We'll create 2d arrays (d is the depth of the tree)
     *
     * Time:  O(n) ; due to we need to traverse all nodes just one time
     * Space: O(n) : because all the nodes are inserted into extra data structures
     */
    fun allPossibleArraysInBst(root: Node<Int>): Array<Array<Int>> {
        val solution = arrayOf<Array<Int>>()

        var i = 0
        val q = LinkedList<Node<Int>>()
        q.add(root)
        while (q.isNotEmpty()) {
            val n = q.poll()
            solution[i] = arrayOf(n.value)

            if (n.right != null) {
                q.add(n.right)
            }
            if (n.left != null) {
                q.add(n.left)
            }
            i++
        }

        return solution
    }

    data class Node<T>(val right: Node<T>?, val left: Node<T>?, val value: T)
}
