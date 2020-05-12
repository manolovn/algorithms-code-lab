package dev.manolovn.crackingcodinginterview.ch04

/**
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height
 */
object MinimalTree {

    /**
     * We'll take a sorted intArray as example input:
     * [1,2,3,4,5,6,7,8,9]
     * it's important to notice that the tree should be with minimal height, it's the
     * challenge of the problem.
     * So the more intuitive solution is to use the middle element as root node,
     * the left hand of the array as left branch and the right hand of the array as right hand
     * and get the middle element of every branch as the next node and so on
     *
     * Time:  O(n) because we need to traverse all the input
     * Space: O(n) because the tree we're creating
     */
    fun toBST(arr: IntArray): Node? = createBranch(arr, 0, arr.size - 1)

    private fun createBranch(arr: IntArray, from: Int, to: Int): Node? {
        if (to < from) {
            return null
        }
        val r = (from + to) / 2
        return Node(
            arr[r],
            createBranch(arr, from, r - 1),
            createBranch(arr, r + 1, to)
        )
    }

    data class Node(
        val value: Int,
        val left: Node? = null,
        val right: Node? = null
    )
}
