package dev.manolovn.crackingcodinginterview.ch04

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: this is not necessarily a BST
 */
object FirstCommonAncestor {

    /**
     * The idea is to find where the paths from nodeA and nodeB intersect
     * We'll get the delta between different heights, traverse from the deepest to parents
     * and then traverse in parallel until find a common ancestor or finish the tree
     *
     * Corner cases:
     * - nodeA is the parent of nodeB : solved
     * - nodeB is the parent of nodeA : solved
     * - node not in the tree : solved
     * - no solution : solved when nodes arrives to the root of the tree
     *
     * Time:  O(H) ; where H is the height of the deeper node
     * Space: O(1) ; no need extra data structure, ignoring the node copy of height func
     *
     * TODO: improve the solution
     */
    fun findFirstCommonAncestor(nodeA: Node, nodeB: Node): Node? {
        val delta = height(nodeA) - height(nodeB)
        var first: Node? = if (delta > 0) nodeB else nodeA
        var secnd: Node? = if (delta < 0) nodeA else nodeB

        while (first != secnd && first != null && secnd != null) {
            first = first.parent
            secnd = secnd.parent
        }

        return if (first == null || secnd == null) null else first
    }

    private fun height(node: Node): Int {
        var n: Node = node.copy()
        var h = 0
        while (n.parent != null) {
            n = n.parent!!
            h++
        }
        return h
    }

    data class Node(val parent: Node?, val left: Node?, val right: Node?)
}
