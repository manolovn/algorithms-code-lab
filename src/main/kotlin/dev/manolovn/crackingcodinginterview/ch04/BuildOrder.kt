package dev.manolovn.crackingcodinginterview.ch04

import dev.manolovn.crackingcodinginterview.ch04.Project.State
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.forEach
import kotlin.collections.set


/**
 * Your are given a list of projects and a list of dependencies (which is a list of pairs of projects,
 * where the second project is dependent on the first project). All of a project's dependencies
 * must be build before the project is. Find a build order that will allow the projects to be build. If there
 * is no valid build order, return an error.
 *
 * Example:
 * Input:
 *   projects: a, b, c, d, e, f
 *   deps: (a, d), (f, b), (b, d), (f, a), (d, c)
 * Output:
 *   f, e, a, b, d, c
 */
object BuildOrder {

    /**
     * The strategy to solve this is a modification of a topological sort
     * We need two big steps:
     *  - build a graph using the input
     *  - order the projects in that graph
     *      - here is were we'll use a topological sort based on a DFS approach
     *      Using DFS we'll traverse the graph marking every node NOT_VISITED as VISITING
     *      This states help us to find cycles inside the graph
     *      Due that DFS particularity we'll resolve the dependencies in reverse order, that's
     *      why a Stack is a good data structure to store the order that while building
     */
    fun getBuildOrderForProjects(projects: Array<String>, deps: Array<Pair<String, String>>): Stack<Project> {
        val graph: Graph = buildGraph(projects, deps)
        return orderProjects(graph.nodes)
    }

    private fun buildGraph(projects: Array<String>, deps: Array<Pair<String, String>>): Graph {
        val graph = Graph()
        projects.forEach { project -> graph.getOrCreate(project) } // add all nodes to graph
        deps.forEach { dep -> graph.addEdge(dep.first, dep.second) } // use deps array to build edges in the graph
        return graph
    }

    private fun orderProjects(projects: ArrayList<Project>): Stack<Project> {
        val stack = Stack<Project>()
        projects.forEach { project ->
            if (project.state == State.NOT_VISITED) {
                dfs(project, stack) // apply a DFS traversing style on not visited nodes
            }
        }
        return stack
    }

    private fun dfs(project: Project, stack: Stack<Project>) {
        if (project.state == State.VISITING) {
            throw Exception("Cycle detected") // if we visit an already visited node, we've found a cycle
        }
        if (project.state == State.NOT_VISITED) {
            project.state = State.VISITING
            val children = project.children
            children.forEach { child -> dfs(child, stack) }
            project.state = State.VISITED
            stack.push(project)
        }
    }
}

class Graph {
    val nodes = ArrayList<Project>()
    val map = HashMap<String, Project>()

    fun getOrCreate(name: String): Project {
        if (!map.containsKey(name)) {
            val node = Project(name)
            nodes.add(node)
            map[name] = node
        }
        return map[name]!!
    }

    fun addEdge(startName: String, endName: String) {
        val start = getOrCreate(startName)
        val end = getOrCreate(endName)
        start.addDependant(end)
    }
}

class Project(val name: String) {
    enum class State {
        NOT_VISITED,
        VISITING,
        VISITED
    }

    var state = State.NOT_VISITED
    val children = ArrayList<Project>()
    val map = HashMap<String, Project>()

    fun addDependant(project: Project) {
        if (!map.containsKey(project.name)) {
            children.add(project)
            map[project.name] = project
        }
    }
}
