package dev.manolovn.crackingcodinginterview.ch04

import java.util.*

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (eg., if you have a tree with depth D, you'll have D linked lists)
 */
object ListOfDepths {

    /**
     * So we need to create a linkedList for every depth of the tree,
     * seems to be a good example of BFS use
     *
     * Time:  O(n) we need to traverse al elements in input
     * Space: O(n) we put all elements to another structure, a bit more due to the queue we need
     *              in the classic BFS implementation
     */
    fun treeToLinkedLists(root: Node): Array<LinkedList<Node>> {
        val linkedLists: Array<LinkedList<Node>> = arrayOf()
        val d = 0
        val q: Queue<Node> = LinkedList()
        q.add(root)
        while (!q.isEmpty()) {
            val n = q.remove()
            q.addAll(n.children)
            linkedLists[d] = createLinkedList(n.children)
        }
        return linkedLists
    }

    private fun createLinkedList(children: Array<Node>): LinkedList<Node> {
        val linkedList = LinkedList<Node>()
        children.forEach { linkedList.add(it) }
        return linkedList
    }

    /**
     * Very simple Node data class
     * Being more strictly, a binary doesn't have children, just a right and left nodes
     * but the implementation is practically identical and this approach is more flexible
     */
    data class Node(
        val children: Array<Node> = emptyArray()
    )
}