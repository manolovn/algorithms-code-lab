package dev.manolovn.crackingcodinginterview.ch04

import java.util.*

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes
 */
object RouteBetweenNodes {

    /**
     * The solution proposed is just make a DFS or BFS trying to find from the node a, the node b
     *
     * DFS approach should be:
     * Time:  O(n) where n is the size of the graph
     * Space: O(n) due to the recursion stack
     */
    fun existsRouteBetweenNodesDFS(a: Node, b: Node): Boolean {
        a.children.forEach { n ->
            if (n == b) {
                return true
            }
            return existsRouteBetweenNodesDFS(n, b)
        }
        return false
    }

    /**
     * BFS approach should be:
     * Time:  O(n) where n is the size of the graph
     * Space: O(n) due to the size of the queue
     */
    fun existsRouteBetweenNodesBFS(a: Node, b: Node): Boolean {
        a.children.forEach { n ->
            val q: Queue<Node> = LinkedList()
            q.add(n)
            while (!q.isEmpty()) {
                val c = q.remove() // current
                if (c == b) {
                    return true
                }
                q.addAll(n.children)
            }
        }
        return false
    }
}

class Node(var children: Array<Node> = emptyArray())
